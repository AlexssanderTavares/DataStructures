import java.lang.reflect.Array;

public class ThirdExerciseProgram {

    public Boolean exec(String word) throws IllegalArgumentException {
        char[] subject;
        int counter = 0;
        int midRange;
        int high;

        if (word != null) {
            subject = word.toLowerCase().toCharArray();
            midRange = word.length() / 2;
            high = word.length() - 1;
        } else {
            throw new IllegalArgumentException("Null value is not allowed");
        }

        while (counter < midRange) {
            if (subject[counter] == subject[high]) {
                counter++;
                high--;
            } else {
                break;
            }
        }

        if (counter == midRange) {
            return true;
        } else {
            return false;
        }
    }
}
