package Zad1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        FileProvider fileProvider=
                new FileProvider("C:\\Users\\marci\\IdeaProjects\\JSON_Projekt\\src\\main\\java\\Zad1\\Pliki\\");

        //fileProvider.readFile("person.json");

        String result = fileProvider.parseJSONFileToString("person.json");
        System.out.println(result);

        ObjectMapper objectMapper = new ObjectMapper();
        // konfiguracja ObjectMapper
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            PersonModel personModel = objectMapper.readValue(result, PersonModel.class);
            System.out.println(personModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String resultTab = fileProvider.parseJSONFileToString("personsTab.json");

        try {
            PersonModel[] personModels = objectMapper.readValue(resultTab, PersonModel[].class);
            System.out.println("\n" + personModels[0] +"\n"+ personModels[1]);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        RestClient restClient = new RestClient();
        String resultResponse = restClient.getResponseInString(200);
        System.out.println(resultResponse);
    }
}
