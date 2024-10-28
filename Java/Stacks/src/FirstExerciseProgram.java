import java.util.Scanner;

public class FirstExerciseProgram {

    public void exec(){
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack<Integer>(10);

        int i = 0;

        while(i <= 9){
            System.out.print("Enter a number: ");
            int num = scan.nextInt();

            if(num % 2 == 0){
                stack.push(num);
            }

            if(num % 2 != 0){
                try {
                    stack.removeTop();
                }catch (IndexOutOfBoundsException exception){
                    System.out.println("No items to remove");
                }catch (NoElementStackedException exception){
                    System.out.println("Stack is empty");
                }
                finally {
                    continue;
                }
            }

            if(stack.isEmpty()){
                System.out.println("Stack is still empty!");
            }

            i++;
        }
        i = 0;

        if(!stack.isEmpty()){
            for(int x = 0; x <= stack.length() - 1; x++) {
                try {
                    String element = stack.getTop().toString();
                    System.out.println(element);
                }catch (NoElementStackedException exception){
                    System.out.println("There is no element inside the stack!");
                }

            }
        }
    }
}
