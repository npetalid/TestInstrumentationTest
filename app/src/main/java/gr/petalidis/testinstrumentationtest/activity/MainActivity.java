package gr.petalidis.testinstrumentationtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import gr.petalidis.testinstrumentationtest.R;
import gr.petalidis.testinstrumentationtest.client.QuoteOfTheDayClient;
import gr.petalidis.testinstrumentationtest.controller.QuoteOfTheDayController;

public class MainActivity extends AppCompatActivity {

    QuoteOfTheDayController client = new QuoteOfTheDayController(new QuoteOfTheDayClient());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Serializable clientSerializable = getIntent().getSerializableExtra("quoteOfTheDay");

        if (clientSerializable != null && clientSerializable instanceof QuoteOfTheDayController) {
            client = (QuoteOfTheDayController) clientSerializable;
        }
        setContentView(R.layout.activity_main);
    }

    public void getQuote(View view) {
        String quote = client.getQuoteOfTheDay();

        TextView textView = (TextView) findViewById(R.id.outputTextView);
        textView.setText(quote);
    }

}
