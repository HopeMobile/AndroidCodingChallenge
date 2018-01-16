package hope.david.AndroidCodingChallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by davidhope on 12/31/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private Context context;


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());

        return new BookViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
