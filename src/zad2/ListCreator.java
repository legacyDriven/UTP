package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator <T> {

    private List<T> instanceList;

    public ListCreator(List<T> list) {
        this.instanceList = list;
    }

    public static <T> ListCreator <T> collectFrom(List<T> arguments) {
        return new ListCreator <T> (arguments);
    }

    public ListCreator <T> when(Predicate<T> isPies) {
        List<T> temp = new ArrayList<>();

        for(T t : instanceList){
            if(isPies.test(t)) temp.add(t);
        }
        this.instanceList = temp;
        return this;
    }

    public <U> List <T> mapEvery(Function <T,U> u) {
        List<T> temp = new ArrayList<>();

        for (T e : instanceList) {
            temp.add( (T) u.apply(e));
        }
        this.instanceList = temp;
        return instanceList;
    }
}