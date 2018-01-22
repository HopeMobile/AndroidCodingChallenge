package hope.david.AndroidCodingChallenge.Book;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hope.david.AndroidCodingChallenge.Model.Book;
import hope.david.AndroidCodingChallenge.Network.BookService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookPresenter  {

    private static final String TAG = BookPresenter.class.getSimpleName();

    @Inject
    BookService bookService;

    private BookItemView bookItemView;

    private List<Book> books = new ArrayList<>();;

     BookPresenter(BookItemView bookItemView, BookService bookService) {
        this.bookItemView = bookItemView;
        this.bookService = bookService;
    }

    // Makes Network call and parses data if successful
     void initData() {

        bookService.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        books.addAll(response.body());

                        Log.v(TAG, "Books: " + books);

                        loadDataSet();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.v(TAG, "Call failed: " + t.getMessage() );
            }
        });
    }
    // Assists with loading the data into the View layer
    void loadDataSet() {

         // 10 == number of items on screen at single time, show Progress bar until then
        if (books.size() < 10) {
            bookItemView.showProgress();
        } else {
            bookItemView.hideProgress();
            bookItemView.showBooks(books);
        }
    }

}
