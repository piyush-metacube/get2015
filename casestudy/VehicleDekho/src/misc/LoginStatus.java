package misc;

public class LoginStatus {
    private static boolean isLogged;

    public static boolean isLogged() {
	return isLogged;
    }

    public static void setLogged(boolean isLoggedStatus) {
	isLogged = isLoggedStatus;
    }

}
