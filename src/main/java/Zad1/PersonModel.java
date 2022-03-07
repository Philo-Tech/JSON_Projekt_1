package Zad1;

public class PersonModel { // jak coś przychodzi z zewnątrz to w nazwie "Model", czyli odzwierciedlenie czegoś
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

    private int id;
    private String name;
    private boolean student;
    private int age;
    private String[] colors;
    private Adress adress;

            public static class Adress {
                private String streetName;
                private String city;
            }

}
