package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.LoginForm;

public class LoginFormImpl implements LoginForm {

    private String name;
    private String password;
    private String email;


    @Override
    public void login(String username, String password) {
        //submit to database to validation
    }

    @Override
    public void register(String username, String password,String email) {
        //submit to database to validation
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //submit to database to validation
    }
}
