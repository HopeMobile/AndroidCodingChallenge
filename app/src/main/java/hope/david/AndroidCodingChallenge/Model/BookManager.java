package hope.david.AndroidCodingChallenge.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidhope on 12/31/17.
 */

public class BookManager {

    private static BookManager bookManager;

    private List<Book> bookList;

    public static BookManager get() {
        if (bookManager == null) {
            bookManager = new BookManager();
        }

        return bookManager;
    }

    private BookManager() {
        bookList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {

        }
    }
}
