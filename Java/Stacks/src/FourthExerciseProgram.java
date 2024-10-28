import java.lang.reflect.Array;

public class FourthExerciseProgram {
    private static final Stack<Integer> binary = new Stack<Integer>(10);
    public FourthExerciseProgram(){
    }

    private static Object[] exec(int num){
        int castedNum = num;

        binary.push(castedNum % 2);

        if(castedNum == 1 || castedNum == 0){
            return binary.invert();
        }

        return exec( num / 2);
    }

    public String getBinaryOf(int num) {
        String bin = "";
        Object[] ourNum = exec(num);
        for(int i = 0; i < ourNum.length - 1; i++){
            if(ourNum[i] != null){
                bin += ourNum[i];
            }
        }
        return bin;
    }


}
