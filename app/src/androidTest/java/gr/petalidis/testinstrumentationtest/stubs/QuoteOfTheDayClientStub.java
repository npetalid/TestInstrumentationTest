package gr.petalidis.testinstrumentationtest.stubs;

import gr.petalidis.testinstrumentationtest.client.IQuoteOfTheDayClient;

/**
 * Created by npetalid on 24/5/18.
 */

public class QuoteOfTheDayClientStub implements IQuoteOfTheDayClient {

    @Override
    public String getQuoteOfTheDayClient(String day) throws Exception {
        return "What's up doc?";
    }
}
