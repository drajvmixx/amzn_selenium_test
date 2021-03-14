package domain.signin;

public class IncorrectLoginDataSignInFormStrategy extends NegativeSignInStrategy {
    public static final String EMAIL_FIELD_INPUT = "Drajvmixxdfhdhsdmail.com";
    public static final String PASSWORD_FIELD_INPUT = "Qwfdghhgderty123";
    public static final String ERROR_MESSAGE_WRONG_SIGNUP_CREDENTIALS = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below";

    @Override
    public void fillData() {
        getSignInLayer().goToSignUpForm();
        getSignInLayer().populateSignUpForm(EMAIL_FIELD_INPUT, PASSWORD_FIELD_INPUT);

    }

    @Override
    public boolean isErrorShown() {
        return getSignInLayer().getErrorMessageIncorrectSignUpCredentials().equals(ERROR_MESSAGE_WRONG_SIGNUP_CREDENTIALS);
    }
}
