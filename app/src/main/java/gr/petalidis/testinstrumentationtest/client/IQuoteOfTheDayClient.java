package gr.petalidis.testinstrumentationtest.client;

import java.io.Serializable;

/**
 * Created by npetalid on 24/5/18.
 */

public interface IQuoteOfTheDayClient extends Serializable {
    String getQuoteOfTheDayClient(String day) throws Exception;
}
