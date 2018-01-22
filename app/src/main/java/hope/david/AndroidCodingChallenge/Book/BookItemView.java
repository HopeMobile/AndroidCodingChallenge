package hope.david.AndroidCodingChallenge.Book;


import java.util.List;

import hope.david.AndroidCodingChallenge.Model.Book;

public interface BookItemView {

    // Implementation used to show the Book objects
    void showBooks(List<Book> books);

    // Implementation used to display progress bar while data loading
    void showProgress();

    // Implementation used to hides progress bar after data is loaded
    void hideProgress();
}
