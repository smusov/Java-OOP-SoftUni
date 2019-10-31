package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;

public class User implements Account {

    private String username;
    private String password;
    private String email;
    private String hashedPassword;


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPasswordHash() {
        return this.hashedPassword;
    }
}
