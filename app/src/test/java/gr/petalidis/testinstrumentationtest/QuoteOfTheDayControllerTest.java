package gr.petalidis.testinstrumentationtest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import gr.petalidis.testinstrumentationtest.client.QuoteOfTheDayClient;
import gr.petalidis.testinstrumentationtest.controller.QuoteOfTheDayController;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class QuoteOfTheDayControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    QuoteOfTheDayClient quoteOfTheDayClient;

    QuoteOfTheDayController quoteOfTheDayController;
    @Before
    public void setUp() {
        quoteOfTheDayController = new QuoteOfTheDayController(quoteOfTheDayClient);
    }
    @Test
    public void testWhenExceptionServiceIsUnavailableShouldBeReturned() throws Exception {
        when(quoteOfTheDayClient.getQuoteOfTheDayClient(anyString())).thenThrow(new Exception());

        assertEquals("Service is unavailable for the moment", quoteOfTheDayController.getQuoteOfTheDay());

    }
}