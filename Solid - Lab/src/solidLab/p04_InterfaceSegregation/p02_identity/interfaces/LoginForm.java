package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface LoginForm {

    void login(String username, String password);

    void register(String username, String password,String email);

    void changePassword(String oldPass, String newPass);
}
