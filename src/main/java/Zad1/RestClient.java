package Zad1;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RestClient {

    public String getResponseInString(int id){
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        HttpGet httpGet = new HttpGet(url); // opakowanie URL w metodę getową (czyli taka któa wysyła przeglądarka)
        HttpClient httpClient = HttpClientBuilder.create().build();// Klient, który będzie wykonywał to wysyłanie
        String responseString;
        HttpResponse httpResponse = null;
        try {
             httpResponse = httpClient.execute(httpGet); // odpowiedź, którą otrzymam, wsadzę w httpResponse
            //parsuje odpowiedź do Stringa
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream inputStream = httpResponse.getEntity().getContent()) {  // nie potrzebuję bloku "finally", ale potrzebuję go zamknąć // daj mi zmienną, daj wartosć

            responseString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException | NullPointerException e){
            e.printStackTrace();
            return null;
        }
        return responseString;
    }
}
