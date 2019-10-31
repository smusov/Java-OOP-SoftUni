package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Validation;

public class ValidatorManager implements Validation {

    private boolean isUniqueEmail;
    private int minPasswordLenght;
    private int maxPasswordLenght;

    @Override
    public boolean getRequireUniqueEmail() {
        return this.isUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minPasswordLenght;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxPasswordLenght;
    }
}
