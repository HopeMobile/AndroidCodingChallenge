package hope.david.AndroidCodingChallenge;

import android.util.Log;

import java.util.List;

import hope.david.AndroidCodingChallenge.Model.Book;
import hope.david.AndroidCodingChallenge.Network.NetworkApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidhope on 12/31/17.
 */

public class BookService {

//    private List<Book>

    public void createNetworkCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Util.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkApi networkApi = retrofit.create(NetworkApi.class);

        Call<List<Book>> call = networkApi.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                        Log.v("Network call worked: ", response.body() + " ");
                    for (Book book: response.body()) {
                        Log.v("Books: ", book + " ");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }
}
