import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.lowerCase;

public class OxfordDictionaryAccess {
    private static final String serverUrl = "https://od-api.oxforddictionaries.com:443/api/v2/entries/";
    private static final String APP_ID = "2da425d5";
    private static final String APP_KEY = "35631121990c9ee1961a30ee0e22245c";

    public List<String> getWordDescription(String word) throws IOException {

        String url = buildURL(word);
        String result = getRequest(url);
        ReadContext ctx = JsonPath.parse(result);
        return ctx.read("$..shortDefinitions[*]");
    }

    private String buildURL(String word) {
        final String language = "en";
        return serverUrl + language + "/" + lowerCase(word);
    }

    private String getRequest(String link) throws IOException {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpUriRequest request = new HttpGet(link);
            request.setHeader("Accept", "application/json");
            request.setHeader("app_id", APP_ID);
            request.setHeader("app_key", APP_KEY);
            HttpResponse execute = httpclient.execute(request);
            InputStream content = execute.getEntity().getContent();
            return IOUtils.toString(content, StandardCharsets.UTF_8);
        }
    }
}