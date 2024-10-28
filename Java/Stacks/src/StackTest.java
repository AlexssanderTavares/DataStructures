import org.junit.*;

import static org.junit.Assert.fail;

public class StackTest {

    static Stack<String> stack = new Stack<String>(10);

    @Before
    public void setup(){
        System.out.println("-----------------------SETUP---------------------------------------");
        for(int i = 0; i <= 8; i++){
            stack.push("test" + i);
        }
        System.out.println(stack.toString());
        System.out.println("Initial length: " + stack.length());
        stack.showTop();
        System.out.println("----------------------END SETUP------------------------------------");
    }

    @After
    public void report(){
        System.out.println("-----------------------REPORT---------------------------------------");
        System.out.println(stack.toString());
        System.out.println("Final length: " + stack.length());
        stack.showTop();

        int i = 0;
        while(i < stack.length()){
            try {
                stack.removeTop();
            }catch (NoElementStackedException exception){
                System.out.println("Stack is empty");
            }
        }
        i = 0;
        System.out.println("----------------------END REPORT------------------------------------");
    }

    @Test
    public void ShouldInvertTheOrderOfTheStack(){
        System.out.println("Testing invert() method");
        String sub1 = stack.toString();
        System.out.println(sub1);
        stack.invert();
        String sub2 = stack.toString();
        System.out.println(sub2);
        assert sub1 != sub2;
    }

    @Test
    public void ShouldGetTheItemOnTheTopOfTheStack(){
        System.out.println("Testing getTop() method");
        try {
            assert stack.getTop().equals("test8");
        }catch (NoElementStackedException exception){
            fail();
        }
    }

    @Test
    public void ShouldAddAnItemOnTheTopOfTheStack(){
        System.out.println("Testing push() method");
        stack.push("TestDummy");
        try {
            assert stack.getTop().equals("TestDummy");
        }catch (NoElementStackedException exception){
            fail();
        }
    }

    @Test
    public void ShouldReturnFalseIfStackHasValues(){
        System.out.println("Testing isEmpty() method");

        assert !stack.isEmpty(); //not true
    }
}
