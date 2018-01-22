package hope.david.AndroidCodingChallenge.Book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import hope.david.AndroidCodingChallenge.BookApplication;
import hope.david.AndroidCodingChallenge.Model.Book;
import hope.david.AndroidCodingChallenge.Network.BookService;
import hope.david.AndroidCodingChallenge.R;
import hope.david.AndroidCodingChallenge.RecyclerView.BooksAdapter;

public class BookActivity extends AppCompatActivity implements BookItemView {

    @Inject
    BookService bookService;

    BookPresenter bookPresenter;

    RecyclerView recyclerView;

    ProgressBar progressBar;

    BooksAdapter booksAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ((BookApplication) getApplication()).getAppComponent().inject(this);

        bookPresenter = new BookPresenter(this, bookService );

        booksAdapter = new BooksAdapter(this);

        progressBar = findViewById(R.id.book_progress_bar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(booksAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Book Presenter methods called here so app can work in multi-window mode
        bookPresenter.initData();
        bookPresenter.loadDataSet();
    }

    @Override
    public void showBooks(List<Book> books) {

        booksAdapter.updateBooks(books);

    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.GONE);
    }
}
