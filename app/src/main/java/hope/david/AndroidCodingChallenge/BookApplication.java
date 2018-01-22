package hope.david.AndroidCodingChallenge;


import android.app.Application;

import hope.david.AndroidCodingChallenge.Network.ApiModule;
import hope.david.AndroidCodingChallenge.Network.NetworkUtil;

public class BookApplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(NetworkUtil.BASE_URL))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
