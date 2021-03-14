package domain.signin;

import domain.SignInLayer;

public abstract class NegativeSignInStrategy {
    abstract public void fillData();

    abstract public boolean isErrorShown() ;

    protected SignInLayer getSignInLayer() {
        return new SignInLayer();
    }
}
