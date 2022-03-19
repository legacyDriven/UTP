Zadanie: ceny przelotów - lambda1

Lista dest zawiera informacje o cenach przelotów w postaci napisów:
port_wylotu port_przylotu cena_w_EUR

Należy utworzyć listę wynikową, której elementy będą opisywać ceny przelotów do poszczególnych miejsc (tylko) z
Warszawy w PLN i wypisać na konsoli jej kolejne elementy.

Aby rozwiązać to zadanie, należy utworzyć sparametryzowaną klasę ListCreator, zawierającą:
statyczną metodę collectFrom (lista)
metodę when
metodę mapEvery
które działają w taki sposób, że symboliczny zapis:

    collectFrom(list).when(lambda-1).mapEvery(lambda-2)

spowoduje utworzenie listy wynikowej, której elementy stanowią wybrane przez lambda-1 elementy listy list,
przekształcone za pomocą podanego lambda-2.

Uwagi:
w zadaniu nie wolno korzystać z własnych interfejsów,
klasa ListCreator i jej metody powinny działać dla list (źródłowej i docelowej) elementów dowolnego typu.

Następujący (niemodyfikowalny poza miejsami oznaczonymi /*<--*/) program:

    import java.util.*;

    public class Main {

      static List<String> getPricesInPLN(List<String> destinations, double xrate) {
        return ListCreator.collectFrom(destinations)
                           .when(  /*<-- lambda wyrażenie
                                    *  selekcja wylotów z Warszawy (zaczynających się od WAW)
                                    */
                            )
                           .mapEvery( /*<-- lambda wyrażenie
                                       *  wyliczenie ceny przelotu w PLN
                                       *  i stworzenie wynikowego napisu
                                       */
                            );
      }

      public static void main(String[] args) {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
          "bleble bleble 2000",
          "WAW HAV 1200",
          "xxx yyy 789",
          "WAW DPS 2000",
          "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
        List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
        for (String r : result) System.out.println(r);
      }
    }
ma wyprowadzić na konsolę napisy:

to HAV - price in PLN:	5160
to DPS - price in PLN:	8600
to HKT - price in PLN:	4300
Postać wydruku jest obowiązkowa.