import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        FirstExerciseProgram res1 = new FirstExerciseProgram();
        SecondExerciseProgram res2 = new SecondExerciseProgram();
        ThirdExerciseProgram res3 = new ThirdExerciseProgram();
        FourthExerciseProgram res4 = new FourthExerciseProgram();

        res1.exec();
        res2.exec();
        System.out.println(res3.exec("aabccbdd"));
        System.out.println(res4.getBinaryOf(41));
    }
}