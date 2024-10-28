import java.util.Scanner;

public class SecondExerciseProgram {

    public void exec(){
        Stack<Integer> pair = new Stack<Integer>(10);
        Stack<Integer> odd = new Stack<Integer>(10);
        Scanner scan = new Scanner(System.in);

        int i = 0;

        while(i <= 9){

            System.out.print("Enter a number: ");
            int num = scan.nextInt();

            if(num % 2 == 0){
                pair.push(num);
            }

            if(num % 2 != 0){
                odd.push(num);
            }

            if(num == 0){
                try{
                    pair.removeTop();
                    odd.removeTop();
                }catch (NoElementStackedException exception){
                    System.out.println("Stack is empty");
                }finally {
                    continue;
                }
            }

            i++;
        }

        if(!pair.isEmpty() && !odd.isEmpty()){
                System.out.println("Pairs");
                System.out.println(pair.toString());
                System.out.println("-----------------------------------------");
                System.out.println("Odds");
                System.out.println(odd.toString());
        }

        
    }
}
