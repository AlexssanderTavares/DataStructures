import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class QueueTest {

    private static Queue<Integer> queue = new Queue<Integer>(10);

    @Before
    public void setup(){
        System.out.println("---------------------SETUP----------------------------");
        for(int i = 0; i <= 8; i++){
            queue.add(i);
        }

        System.out.println("Initial queue state: " + queue.toString());
        System.out.println("Initial queue length: " + queue.length());
        queue.showNext();

        System.out.println("---------------------SETUP----------------------------");
    }

    @After
    public void report(){
        System.out.println("---------------------REPORT----------------------------");
        System.out.println("Initial queue state: " + queue.toString());
        System.out.println("Initial queue length: " + queue.length());
        queue.showNext();

        queue.resetQueue();

        System.out.println("---------------------REPORT----------------------------");
    }

    @Test
    public void ShouldVerifyQueueToAssetIfItIsEmptyOrNot(){
        System.out.println("Testing isEmpty() method...");
        assert !queue.isEmpty();
    }

    @Test
    public void ShouldReturnTheCurrentLengthBasedOnSetupEnvironment(){
        System.out.println("Testing length() method...");
        assert queue.length() != 0 || queue.length() != -1;
    }

    @Test
    public void ShouldInsertAValueInsideTheQueueAndItMustBeInTheLastPosition(){
        System.out.println("Testing add() method...");
        System.out.println("Adding some value");
        queue.add(45);

        assert queue.length() == 10;
    }

    @Test
    public void ShouldAssertThatTheCapactiYWillBeIncreasedWhenQueueIsFull(){
        System.out.println("Testing increaseCapacity() method...");
        System.out.println("Adding some value");
        queue.add(78);
        System.out.println(queue.toString());
        System.out.println("Trying to add another value when queue is full");
        queue.add(89);
        assert queue.length() == 11;
    }

    @Test
    public void ShouldGetTheNextItemOfTheQueueReturnAndRemoveFromQueue(){
        System.out.println("Testing getNext() method...");
        try{
            assert queue.getNext() == 0;
        } catch (EmptyQueueException e) {
            fail();
        }
    }

    @Test
    public void ShouldResetAllValuesOfTheQueue(){
        System.out.println("Testing resetQueue() method...");
        queue.resetQueue();
        assert !queue.toString().equals("[0, 1, 2, 3, 4, 5, 6, 7, 8, null]");
    }
}
