package Zad1;

public class Main {
    public static void main(String[] args) {
        FileProvider fileProvider=
                new FileProvider("C:\\Users\\marci\\IdeaProjects\\JSON_Projekt\\src\\main\\java\\Zad1\\Pliki\\");

        //fileProvider.readFile("person.json");

        System.out.println(fileProvider.readJSONFile("person.json"));
    }
}
