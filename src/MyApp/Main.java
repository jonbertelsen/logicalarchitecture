package MyApp;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

public class Main {

    public static void main(String[] args) {

        // Instantiate AppLayer and UIlayer:
        AppLayer MyApplication = new AppLayer();

        MyApplication.enterAndCheckUserCredentials();
    }
}
