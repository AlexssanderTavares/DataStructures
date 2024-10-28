import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VectorTest {

    static Vector vector = new Vector<String>(10);

    @Before
    public void setUp(){
        System.out.println("---------------------------------------");
        for(int i = 0; i < 8; i++){
            vector.add("test" + i);
        }
        vector.show();
        System.out.println("Vector length: " + vector.length);
        System.out.println("Initial vector size: " + vector.size());
        System.out.println("---------------------------------------");
    }

    @After
    public void report(){
        System.out.println("---------------------------------------");
        System.out.println(vector.toString());
        System.out.println("Last vector size: " + vector.size());
        System.out.println("Last Vector length: " + vector.length);
        vector.clear();
        System.out.println("---------------------------------------");
    }

    @Test
    public void ShouldLengthIncreaseWhenFunctionAddIsCalled(){
        System.out.println("Testing Add function");
        try{
            vector.add("testAdd");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Not enough capacity");
        }
        assert vector.length > 0;
    }

    @Test
    public void ShouldPopReduceVectorLengthWhenCalled(){
        System.out.println("Testing Pop function");
        vector.remove(6);
        System.out.println("Showing result");
        vector.show();

        assert vector.length < 10;
        assert vector.get(6).equals("test7");
    }

    @Test
    public void ShouldGetFindValueByIndex(){
        System.out.println("Testing Get function for not null value return");
        System.out.println("Adding value on the next index");
        vector.add("testGet");
        try{
            assert vector.get(8).equals("testGet");
        }catch (IllegalArgumentException e){
            System.out.println("Invalid index");
        }
    }

    @Test
    public void ShouldGetReturnNullValue(){
        System.out.println("Testing Get function for null value return");
        System.out.println("Adding value on the first index");
        vector.add("testGet2");
        try{
            assert vector.get(9) == null;
        }catch (IllegalArgumentException e){
            System.out.println("Invalid index");
        }
    }

    @Test
    public void ShouldSearchFindAndReturnANotNullValue(){
        System.out.println("Testing search function to find test5");
        assert vector.search("test5");
    }

    @Test
    public void ShouldSearchFailsWhenSearchingNonInsertedValues(){
        System.out.println("Testing Search function to find test15");
        assert !vector.search("test15");
    }

    @Test
    public void ShouldSearchAndGetElementByIndex(){
        System.out.println("Testing findIndex() method");
        System.out.println("Trying to find test6 index");
        assert vector.findIndex("test6") == 6;
    }

    @Test
    public void ShouldInsertInIndexFunctionInsertInAnyDeservedIndex(){
        try{
            vector.insertInIndex(3,"TestDoll");
            vector.show();
            assert vector.get(3) == "TestDoll";

        }catch(IllegalArgumentException e){
            System.out.println("Invalid index");
        }
    }

    @Test
    public void ShouldIncreaseCapacityWithouLosingItValues(){
        System.out.println("Testing increaseCapacity() method");
        System.out.println("Increasing by 4");
        vector.increaseCapacity(4);
        System.out.println("Showing it values");
        vector.show();

        assert vector.size() == 12;
    }
}
