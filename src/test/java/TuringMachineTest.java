import org.junit.Test;

import java.io.StringReader;
import java.util.Map;

import static org.junit.Assert.*;

public class TuringMachineTest {
    @Test
    public void test() throws Exception {
        String rulesString =
                "q1 # -> q2 # R\n" +
                "q2 0 -> q2 # R\n" +
                "q2 1 -> q2 1 R\n" +
                "q2 # -> q0 0 L";
        Map<TransitionKey, TransitionValue> rules = new RulesParser().parseRules(new StringReader(rulesString));
        Strip<Character> strip = new StringBuilderBasedStrip("#01#");
        TuringMachine turingMachine = new TuringMachine(strip, "q1", rules);
        while (!turingMachine.isStopped()) {
            turingMachine.doStep();
        }
        assertEquals("##10", strip.toString());
    }
}