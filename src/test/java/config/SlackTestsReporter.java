package config;

import okhttp3.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.util.stream.Collectors;

public class SlackTestsReporter implements ITestListener {

    private static final String HOOK_URL = "https://hooks.slack.com/services/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";

    @Override
    public void onFinish(ITestContext testContext) {
        StringBuilder report = new StringBuilder();
        report.append("failed:\n");

        String result = testContext.getFailedTests().getAllResults()
                .stream()
                .map(ITestResult::getName)
                .collect(Collectors.joining("; \n"));

        report.append(result);
        report.append("\n\npassed:\n");

        result = testContext.getPassedTests().getAllResults()
                .stream()
                .map(ITestResult::getName)
                .collect(Collectors.joining("; \n"));

        report.append(result);
        sendToSlack(report.toString());
    }

    private void sendToSlack(String data) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"text\": \"" + data + "\"}");
        Request request = new Request.Builder()
                .url(HOOK_URL)
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