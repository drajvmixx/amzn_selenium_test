package domain.signin;

public class EmptySignInFormStrategy extends NegativeSignInStrategy {
    public static final String ERROR_MESSAGE_OF_EMPTY_SIGN_IN_FIELD = "Enter your email or mobile phone number";

    @Override
    public void fillData() {
        getSignInLayer().signInWithEmptyField();
    }

    @Override
    public boolean isErrorShown() {
       return getSignInLayer().getErrorMessageOfEmptySignInField().equals(ERROR_MESSAGE_OF_EMPTY_SIGN_IN_FIELD);
    }


}
