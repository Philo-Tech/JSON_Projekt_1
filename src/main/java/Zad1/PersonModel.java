package Zad1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class PersonModel { // jak coś przychodzi z zewnątrz to w nazwie "Model", czyli odzwierciedlenie czegoś

    private int id;
    @JsonProperty(value = "userName") // padnie ktoraś metoda bo zmieniłęm w "personsTab.json"
                                        // ale ze zmieniłem "objectMapper.configure", to wypluje "NULL" jak nie rozpozna
    private String name;
    private boolean student;
    private int age;
    private String[] colors;
    private Adress adress;

            public static class Adress {
                private String streetName;
                private String city;

                public String getStreetName() {
                    return streetName;
                }

                public void setStreetName(String streetName) {
                    this.streetName = streetName;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                @Override
                public String toString() {
                    return "Adress{" +
                            "streetName='" + streetName + '\'' +
                            ", city='" + city + '\'' +
                            '}';
                }
            }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", age=" + age +
                ", colors=" + Arrays.toString(colors) +
                ", adress=" + adress +
                '}';
    }
}


/*
 * JSON - Java Script Object Notation (zapis obiektowy w JS)
 * Potrzeba dodatkowych Klas/ zależności w Maven
 *
 *  Klamry rozpoczynają Obiekt/ zapis klasy w JSON
 * #######################################
 * Person
 * {
 *       "id": 124,
 *       "name": "Lukasz",
 *       "student": false,
 *       "age": 30,
 *       "colors": [
 *       "red","blue","green"
 *       ],
 *       Address: {
 *       "streetName" : "warszwska",
 *       "city" : "Warszawa"
 *       }
 *
 * }
 * ########################################
 * */
