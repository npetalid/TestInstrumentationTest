package gr.petalidis.testinstrumentationtest.client;

/**
 * Created by npetalid on 17/5/18.
 */

public class QuoteOfTheDayClient implements IQuoteOfTheDayClient {
    private String quote = "";

    @Override
    public String getQuoteOfTheDayClient(String day) throws Exception {
        return quote;
    }
}
