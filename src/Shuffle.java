import java.util.ArrayList;
import java.util.Collections;

public class Shuffle {

    int[] shuffle(int[] intArray){

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i < intArray.length; i++) {
            integerArrayList.add(intArray[i]);
        }
        Collections.shuffle(integerArrayList);
        for (int i = 0; i < intArray.length; i++) {
            int i1 = integerArrayList.get(i);
            intArray[i] = i1;
        }
        return intArray;
    }
}
