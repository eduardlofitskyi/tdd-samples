import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduard on 1/12/16.
 */
public class Stack {

    private List<Integer> elems = new ArrayList<>();

    public boolean isEmpty() {
        return elems.isEmpty();
    }

    public void push(int elem) {
        elems.add(elem);
    }

    public int size() {
        return elems.size();
    }

    public int pop() {
        int index = elems.size()-1;
        return elems.remove(index);
    }
}
