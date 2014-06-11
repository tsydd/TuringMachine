import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class TuringMachineRunner {
    public static void main(String[] args) {
        Map<TransitionKey, TransitionValue> rules = new HashMap<>();

        Strip<Character> strip = new StringBuilderBasedStrip("#01#");
        TuringMachine turingMachine = new TuringMachine(strip, "q1", rules);
        do {
//            TransitionValue transitionValue = turingMachine.doStep();
            System.out.println(strip);
        } while (!turingMachine.isStopped());
    }
}
