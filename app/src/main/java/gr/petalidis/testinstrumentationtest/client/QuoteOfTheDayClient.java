package gr.petalidis.testinstrumentationtest.client;

/**
 * Created by npetalid on 17/5/18.
 */

public class QuoteOfTheDayClient implements IQuoteOfTheDayClient {
    private String quote = "This is news to me!";

    @Override
    public String getQuoteOfTheDayClient(String day) throws Exception {
        return quote;
    }
}
