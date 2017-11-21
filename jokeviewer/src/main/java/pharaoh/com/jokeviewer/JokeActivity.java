package pharaoh.com.jokeviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    TextView textview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);

        textview = (TextView) findViewById(R.id.joke_content);

        String joke = getIntent().getStringExtra("joke");

        if (joke != null) {
            textview.setText(joke);
        } else {
            textview.setText("no joke found , please try again !");
        }
    }
}
