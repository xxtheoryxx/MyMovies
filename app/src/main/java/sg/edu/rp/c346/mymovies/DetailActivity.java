package sg.edu.rp.c346.mymovies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class DetailActivity extends Activity {

    TextView tvTitle;
    TextView tvDetail;
    TextView tvDesc;
    TextView tvDate;
    TextView tvTheatre;
    ImageView ivRated;
    RatingBar rbRated;
    ArrayList<MoviesItem> alMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intentRecieved = getIntent();
        MoviesItem movie = (MoviesItem) intentRecieved.getSerializableExtra("movies");

    }
}
