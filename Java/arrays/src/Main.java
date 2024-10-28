//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int[] arr1 = new int[10];

        for(int i = 0; i < arr1.length; i++){
            arr1[i] += i;
        }

        for(int num : arr1){
            System.out.println(num);
        }

        Vector vector = new Vector(10);

        System.out.println(vector);

        try{
            vector.add("Hello");
            System.out.println(vector.toString());
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index higher than Vector size"+
                    "Vector size: " + vector.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /*for(int i = 0; i < vector.length; i++){
            System.out.println(vector);
        }*/
    }
}