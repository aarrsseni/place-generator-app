package pet.project.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class DefaultParsingService implements ParsingService {

    private static final String relaxNewPlaceUrl = "https://mag.relax.by/food/place/";

    private static final String relaxCafesUrl = "https://www.relax.by/cat/ent/cafe/";

    private Random random = new Random();

    @Override
    public String getRandomNewPlace() {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        String result = "";
        try {
            HtmlPage page = client.getPage(relaxNewPlaceUrl);
            List<HtmlAnchor> anchors = (List<HtmlAnchor>)page.getByXPath("//a[@class='b-journal_rubrika-new_item_lnk']");
            result = anchors.get(random.nextInt(anchors.size())).getHrefAttribute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getCafe() throws JsonProcessingException {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        Map<String, String> result = new HashMap<>();
        try {
            HtmlPage page = client.getPage(relaxCafesUrl);
            List<HtmlElement> elements = (List<HtmlElement>) page.getByXPath("//div[@class='PlaceList__itemWrapper']");
            HtmlElement htmlElement = elements.get(random.nextInt(elements.size()));
            HtmlAnchor itemAnchor = htmlElement.getFirstByXPath(".//a");
            result.put("Url", itemAnchor.getHrefAttribute());
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ObjectMapper().writeValueAsString(result);
    }
}
