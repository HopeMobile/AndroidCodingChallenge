package hope.david.AndroidCodingChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BookAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        BookService bookService = new BookService();
        bookService.createNetworkCall();
    }
}
