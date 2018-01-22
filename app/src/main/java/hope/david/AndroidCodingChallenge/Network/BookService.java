package hope.david.AndroidCodingChallenge.Network;

import java.util.List;

import hope.david.AndroidCodingChallenge.Model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by davidhope on 12/31/17.
 */

public interface BookService {

    @GET("books.json")
    Call<List<Book>> getBooks();

}
