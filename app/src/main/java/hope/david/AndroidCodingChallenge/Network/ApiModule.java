package hope.david.AndroidCodingChallenge.Network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    // Module used for all network dependencies used in App

    private String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // Will Be used for other GET and POST REST calls
    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Assembly the pieces needed for network call
    @Provides
    @Singleton
    BookService providesBookService() {
        return providesRetrofit().create(BookService.class);
    }
}
