package Zad1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileProvider {

    private final String path;

    public FileProvider(String path) {
        this.path = path;
    }

    public void readFile(String fileName) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) { // IOException jest nadrzędny do FileNotFoundException
            e.printStackTrace();
        }
    }

    public String parseJSONFileToString(String fileName) {
        BufferedReader bufferedReader;
        StringBuilder result = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            result.append(line);
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null)
                    result.append(line.replaceAll("\\s+", ""));//s-> biały znak | + -> jeden lub więcej
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void createFileFromCollectio(String fileName, List<String> list) {
        Path pathWithName = Paths.get(this.path + fileName);

        try {
            if (Files.notExists(pathWithName)) Files.createFile(pathWithName);
            Files.write(pathWithName, list, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
