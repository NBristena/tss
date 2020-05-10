package Pachet1;
public class MyClass {

    public int method(int[] array, int lowerboud, int upperbound, int key) {
        if (lowerboud != 0 || upperbound != array.length - 1) {
            System.out.print("Indicii nu sunt corecti\n");
            return -2;
        }
        else {
            for (int i = lowerboud; i <= upperbound; i++) {
                if (array[i] == key) {
                    System.out.print("Valoarea a fost gasita la indicele " + i + "\n");
                    return i;
                }
            }
            System.out.print("Valoarea nu a fost gasita in vector\n");}
        return -1;
    }
}



