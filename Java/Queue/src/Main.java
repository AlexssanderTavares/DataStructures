import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Document doc1 = new Document("Medical Herbs" , 5);
        Document doc2 = new Document("Modern Operational Systems" , 5);
        Document doc3 = new Document("Computer Networks", 5);
        Document doc4 = new Document("Cake recipes", 5);

        Printer printer = new Printer();


        printer.addToQueue(doc1, doc2, doc3, doc4);
        printer.printDocument();
    }
}

