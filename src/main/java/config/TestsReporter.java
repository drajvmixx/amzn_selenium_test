package config;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import okhttp3.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestsReporter implements ITestListener {

    private static final String SLACK_HOOK_URL = "https://hooks.slack.com/services/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";
    private static final APIClient client = new APIClient("https://irynaep.testrail.io/");
    private static int TEST_RAIL_PASSED_STATUS = 1;
    private static int TEST_RAIL_FAILED_STATUS = 5;

    public TestsReporter() {
        client.setUser("...@gmail.com");
        client.setPassword("...");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        prepareTestRailReport(testContext);
        prepareSlackReport(testContext);
    }

    private void prepareTestRailReport(ITestContext testContext) {

        testContext.getFailedTests().getAllResults()
                .stream()
                .map(res -> res.getMethod())
                .map(m -> m.getDescription())
                .filter(testName -> Objects.nonNull(testName))
                .forEach(testName -> sendToTestRail(testName, TEST_RAIL_FAILED_STATUS));

        testContext.getPassedTests().getAllResults()
                .stream()
                .map(res -> res.getMethod())
                .map(m -> m.getDescription())
                .filter(testName -> Objects.nonNull(testName))
                .forEach(testName -> sendToTestRail(testName, TEST_RAIL_PASSED_STATUS));

    }

    private void sendToTestRail(String testName, int status) {
        String[] parsedTestName = testName.split("TC_ID=C");
        if (parsedTestName.length > 1) {
            String testCaseId = parsedTestName[1];

            Map<String, Integer> body = new HashMap<>();
            body.put("status_id", status);

            try {
                client.sendPost("add_result_for_case/1/" + testCaseId, body);
            } catch (IOException | APIException e) {
                e.printStackTrace();
            }
        }

    }

    private void prepareSlackReport(ITestContext testContext) {
        StringBuilder report = new StringBuilder("Failed:\n");

        String result = testContext.getFailedTests()
                .getAllResults()
                .stream()
                .map(res -> res.getName())
                .collect(Collectors.joining("; \n"));

        report.append(result);
        sendToSlack(report.toString());
    }

    private void sendToSlack(String data) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"text\": \"" + data + "\"}");
        Request request = new Request.Builder()
                .url(SLACK_HOOK_URL)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

}