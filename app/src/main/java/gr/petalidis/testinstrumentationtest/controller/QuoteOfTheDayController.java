package gr.petalidis.testinstrumentationtest.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import gr.petalidis.testinstrumentationtest.client.IQuoteOfTheDayClient;

/**
 * Created by npetalid on 24/5/18.
 */

public class QuoteOfTheDayController implements Serializable {

    private final IQuoteOfTheDayClient client;

    public QuoteOfTheDayController(IQuoteOfTheDayClient client) {
        this.client = client;
    }

    public String getQuoteOfTheDay() {
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());

        try {
            return client.getQuoteOfTheDayClient(weekDay);
        } catch (Exception e) {
            return "Service is unavailable for the moment";
        }

    }
}
