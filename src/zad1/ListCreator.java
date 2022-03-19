/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator <T> { // Uwaga: klasa musi być sparametrtyzowana

    private List<T> instanceList;

    public ListCreator(List<T> instanceList) {
        this.instanceList = instanceList;
    }
    public static <T> ListCreator <T> collectFrom(List<T> list) {
        ListCreator output = new ListCreator(list);
        return output;
    }

    public ListCreator <T> when(Selector <T> sel){
        List <T> output = new ArrayList<>();

        for(T t : instanceList){
            if (sel.select(t)) output.add(t);
        }
        instanceList = output;
        return this;
    }

    public <U> List <U> mapEvery (Mapper <T,U> map){
        List <U> output = new ArrayList<>();

        for (T t : instanceList){
            U element = (U) t;
            output.add(map.map((T) element));
        }
        return output;
    }
}
