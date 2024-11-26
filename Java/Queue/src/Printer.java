import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class Printer {

    private final PriorityQueue<Document> docs = new PriorityQueue<Document>();

    public Printer(){
    }

    public void addToQueue(Document... args){
        for(int i = 0; i <= args.length-1; i++){
            System.out.println("Adding " + args[i].getName() + " to the printer queue...");
            docs.add(args[i]);
        }
        System.out.println("All files added to the queue");
    }

    public boolean printDocument(){
        while(!docs.isEmpty()){
            System.out.println("Printing " + docs.remove().getName() + "..." );
            if(docs.isEmpty()){
                System.out.println("There is no documents anymore to be printed");
                return true;
            }
        }
        System.out.println("There is no documents to be printed");
        return false;
    }
}
