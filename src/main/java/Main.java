import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {
    public static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=aEjwVRehQFzIt5RYwEpREkADCdFtPI3uGpkVmIOT";
    public static ObjectMapper mapper = new ObjectMapper();
    public static String DIRECTORY = "NasaPictures";

    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(NASA_API);
        CloseableHttpResponse response = httpClient.execute(request);

        NasaResponse nasaResponse = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<NasaResponse>() {
                });

        String url = nasaResponse.getUrl();

        try (InputStream inputStream = new URL(url).openStream()) {
            Files.copy(inputStream, Paths.get(DIRECTORY + "/" + url.substring(url.lastIndexOf("/") + 1)),
                    StandardCopyOption.REPLACE_EXISTING);
        }

    }
}
