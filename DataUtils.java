import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class DataUtils {

    public static ArrayList<University> copyAndShuffle(
            ArrayList<University> original) {

        ArrayList<University> copy =
                new ArrayList<>(original);

        Collections.shuffle(copy);

        return copy;
    }

    public static LinkedList<University> copyAndShuffleLinked(
            LinkedList<University> original) {

        LinkedList<University> copy =
                new LinkedList<>(original);

        Collections.shuffle(copy);

        return copy;
    }
}