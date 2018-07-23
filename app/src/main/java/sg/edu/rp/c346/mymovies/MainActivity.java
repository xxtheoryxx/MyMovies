package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    ListView lvMovie;
    ArrayList<MoviesItem> alMovie;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.textViewTitle);
        lvMovie = findViewById(R.id.listViewMovies);

        alMovie = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.set(2014, 11, 15);
        date2.set(2015, 5, 15);
        MoviesItem movie1 = new MoviesItem("The Avengers", "2012", "pg13", "Action | Sci-Fi",
                date1,"Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",
                4);
        alMovie.add(movie1);
        MoviesItem movie2 = new MoviesItem("Planes", "2013", "pg", "Animations | Comedy", date2,
                "Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",
                2);
        alMovie.add(movie2);


        caMovie = new CustomAdapter(this, R.layout.movie_row, alMovie);

        lvMovie.setAdapter(caMovie);
        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("movies", alMovie);
                startActivity(intent);
            }
        });


    }


}
