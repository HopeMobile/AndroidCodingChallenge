package hope.david.AndroidCodingChallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by davidhope on 12/31/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    private ImageView bookImageView;
    private TextView bookTextView;


    public BookViewHolder(LayoutInflater inflater, ViewGroup itemView) {
        super(inflater.inflate(R.layout.book_item_layout, itemView, false));
        ;
    }
}
