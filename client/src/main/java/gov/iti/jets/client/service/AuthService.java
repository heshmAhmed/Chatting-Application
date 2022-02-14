package gov.iti.jets.client.service;

public class AuthService {
    private static AuthService loginService = new AuthService();

    public static AuthService getInstance() {
        return loginService;
    }
}
