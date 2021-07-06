package ExchangeRate;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Locale;

public class ExchangeRate {

    private static String EXCHANGE_URL = "http://www.nbg.ge/rss.php";
    private static final Integer CURRENCY_NAME_TAG_INDEX = 0;
    private static final Integer CURRENCY_AMOUNT_TAG_INDEX = 1;
    private static final Integer CURRENCY_MONEY_TAG_INDEX = 2;

    private static Integer getCurrencyAmount(org.jsoup.nodes.Element tr){
        String amountText = tr.child(CURRENCY_AMOUNT_TAG_INDEX).text();
        amountText = amountText.substring(0,amountText.indexOf(" "));
        Integer result = Integer.parseInt(amountText);
        return result;
    }

    private static Elements getParsedCurrencyDataXMLFromURL() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(EXCHANGE_URL);

        Element root = document.getDocumentElement();
        root.normalize();

        Node descriptionNode = document.getElementsByTagName("description").item(1);
        String currencyDataHTML = descriptionNode.getTextContent();

        org.jsoup.nodes.Document parsedHTML = Jsoup.parse(currencyDataHTML);
        Elements trs = parsedHTML.getElementsByTag("tr");

        return trs;
    }

    public static double exchangeRate(String from,String to) throws ParserConfigurationException, IOException, SAXException {
        Elements trs = getParsedCurrencyDataXMLFromURL();

        Double fromGEL = null;
        Integer fromAmount = null;
        Double toGEL = null;
        Integer toAmount = null;

        if(from.toUpperCase().equals("GEL")){
            fromGEL = 1.0;
            fromAmount = 1;
        }
        if(to.toUpperCase().equals("GEL")){
            toGEL = 1.0;
            toAmount = 1;
        }

        if(fromGEL == null || toGEL == null){
            for(org.jsoup.nodes.Element tr: trs){
                String currency = tr.child(CURRENCY_NAME_TAG_INDEX).text();
                if(currency.equals(from.toUpperCase())){
                    fromGEL = Double.parseDouble(tr.child(CURRENCY_MONEY_TAG_INDEX).text());
                    fromAmount = getCurrencyAmount(tr);
                } else if(currency.equals(to.toUpperCase())){
                    toGEL = Double.parseDouble(tr.child(CURRENCY_MONEY_TAG_INDEX).text());
                    toAmount = getCurrencyAmount(tr);
                }
            }
        }

        if(fromGEL == null)
            throw new RuntimeException(from + " Currency could not be found");
        if(toGEL == null)
            throw new RuntimeException(to + " Currency could not be found");

        fromGEL /= fromAmount;
        toGEL /= toAmount;

        double result = fromGEL / toGEL;
        return result;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        System.out.println(exchangeRate("AUD","CZK"));
    }
}
