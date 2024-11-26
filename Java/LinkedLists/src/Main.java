import javax.xml.transform.stream.StreamSource;
import java.net.StandardSocketOptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

       // list.clear();

        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list.toString());
        System.out.println("Index of 8: " + list.indexOf(10));
        System.out.println("Searching in position 7: " + list.search(9));

        list.addIn(3,33);
        System.out.println(list);

        list.popFrom(4);
        System.out.println(list);

    }
}