package Utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XPathExtractor {

    public static String extractXPathFromWebElement(WebElement webElement) {
        int startIndex = webElement.toString().indexOf("xpath: ");
        if (startIndex != -1) {
            return webElement.toString().substring(startIndex + 7).trim();
        } else {
            return null;
        }
    }

}
