package hope.david.AndroidCodingChallenge.Model;

/**
 * Created by davidhope on 12/31/17.
 */

public class Book {

    String title;
    String imageUrl;

    public Book(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
