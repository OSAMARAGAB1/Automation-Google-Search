import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleResultTests extends BaseTest {

    @Test
    public void VerifyAllGoogleResults() {
        // TODO:Enter Text in search area
        googleHomePage.enterText("test AUTOMATION");
        //TODO: Submit text
        googleHomePage.submitButton();
        //TODO: Assert on Results
        Assert.assertTrue(googleHomePage.assertAllResults("test automation"), "No search result contains the query text: ");
    }

    @Test
    public void VerifyOneOfGoogleResults() {
        // TODO:Enter Text in search area
        googleHomePage.enterText("test AUTOMATION");
        //TODO: Submit text
        googleHomePage.submitButton();
        //TODO: Assert on Results
        Assert.assertTrue(googleHomePage.assertOnOfResults("test automation"), "No search result contains the query text: ");
    }

    @Test
    public void VerifyFirstGoogleResult() {
        // TODO:Enter Text in search area
        googleHomePage.enterText("test AUTOMATION");
        //TODO: Submit text
        googleHomePage.submitButton();
        //TODO: Assert on Results
        Assert.assertTrue(googleHomePage.assertFirstResult("test automation"), "No search result contains the query text: ");
    }
}
