package MyApp.AppLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

public class Main {

    public static void main(String[] args) {

        // Instantiate UserLogin and UIlayer:
        UserLogin MyApplication = new UserLogin();

        MyApplication.enterAndCheckUserCredentials();
    }
}
