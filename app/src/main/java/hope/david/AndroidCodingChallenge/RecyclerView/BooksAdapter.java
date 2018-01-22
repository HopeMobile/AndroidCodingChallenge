package hope.david.AndroidCodingChallenge.RecyclerView;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import hope.david.AndroidCodingChallenge.Model.Book;
import hope.david.AndroidCodingChallenge.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> books = new ArrayList<>();

    // Need context to work with Picasso
    private WeakReference<Context> context;

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImageView;
        TextView bookTitleTextView;
        TextView bookAuthorTextView;

        ViewHolder(View itemView) {
            super(itemView);

            bookTitleTextView = itemView.findViewById(R.id.book_title_text_view);
            bookAuthorTextView = itemView.findViewById(R.id.book_author_text_view);
            bookImageView = itemView.findViewById(R.id.book_icon_image_view);
        }
    }

    public BooksAdapter (Context context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Book book = books.get(position);

        String bookTitle = book.getTitle();

        Context context = this.context.get();
        if (context != null) {
            Picasso.with(context)
                    .load(book.getImageURL())
                    .resize(200, 200)
                    .centerInside()
                    .into(holder.bookImageView);

            // Author value not always present, must check
            if (book.getAuthor() != null) {

                /*String bookAuthor = context.getResources().getString(R.string.author_prefix)
                        .concat( " "  + book.getAuthor());*/

                StringBuilder booksAuthor = new StringBuilder().append(context.getResources().getString(R.string.author_prefix))
                        .append(" ")
                        .append(book.getAuthor());

                holder.bookAuthorTextView.setText(booksAuthor);
            }
        }

        holder.bookTitleTextView.setText(bookTitle);

    }


    public void updateBooks(List<Book> books) {

        //Update entire list. Bad performance with notifyDataSetChanged()
        this.books = books;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return books.size();
    }
}
