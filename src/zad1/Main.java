/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12); /*<-- tu dopisać inicjację elementów listy */
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");/*<-- tu dopisać inicjację elementów listy */
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector <Integer> sel = new Selector<Integer>() {
      @Override
      public boolean select(Integer argument) {
        if(argument < 10) return true;
        return false; }}; /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */

    Mapper <Integer, Integer> map = new Mapper<Integer, Integer>() {
      @Override
      public Integer map(Integer argument) {
        return argument + 10; }};  /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */

      return ListCreator.collectFrom(src).when(sel).mapEvery(map);/*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */
  }

  public List<Integer> test2(List<String> src) {
    Selector <String> sel = new Selector<String>() {
      @Override
      public boolean select(String argument) {
        if(argument.length()>3) return true;
        return false; }};
    /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper <String,Integer> map = new Mapper<String, Integer>() {
      @Override
      public Integer map(String argument) {
        return argument.length()+10; }};  /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
 /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  }

  public static void main(String[] args) {
    new Main();
  }
}
