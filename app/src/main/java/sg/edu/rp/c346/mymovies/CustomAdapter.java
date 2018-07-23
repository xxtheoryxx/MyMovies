package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15055494 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<MoviesItem> moviesList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MoviesItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        moviesList = objects;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDetails = rowView.findViewById(R.id.textViewDetail);
        TextView tvDesc = rowView.findViewById(R.id.textViewDesc);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        TextView tvTheatre = rowView.findViewById(R.id.textViewTheatre);
        RatingBar rbRated= rowView.findViewById(R.id.ratingBar);
        ImageView ivRated = rowView.findViewById(R.id.imageViewRating);

        MoviesItem currentItem = moviesList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDetails.setText(currentItem.getYear()+" - "+currentItem.getGenre());
        if (currentItem.getRated() == "g"){
            ivRated.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRated() == "pg"){
            ivRated.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRated() == "pg13"){
            ivRated.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRated() == "nc16"){
            ivRated.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRated() == "m18"){
            ivRated.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRated() == "r21") {
            ivRated.setImageResource(R.drawable.rating_r21);
        }
        tvDesc.setText(currentItem.getDescription());
        tvDate.setText(String.valueOf(currentItem.getWatched_on()));
        tvTheatre.setText(currentItem.getIn_theatre());
        rbRated.setNumStars(currentItem.getRating());

        return rowView;

    }
}
