import javax.swing.*;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class TuringMachineRunner {

    private static File openRulesFile() {
        JFileChooser fileChooser = new JFileChooser(".");
        switch (fileChooser.showOpenDialog(null)) {
            case JFileChooser.APPROVE_OPTION:
                return fileChooser.getSelectedFile();
            default:
                return null;
        }
    }

    private static Map<TransitionKey, TransitionValue> readRules() throws IOException {
        File file;
        do {
            file = openRulesFile();
        } while (file == null);

        try (Reader reader = new FileReader(file)) {
            return new RulesParser().parseRules(reader);
        }
    }

    private static String readInputString() {
        System.out.println("enter string");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) throws IOException {
        Map<TransitionKey, TransitionValue> rules = readRules();
        String inputString = readInputString();

        Strip<Character> strip = new StringBuilderBasedStrip(inputString);
        TuringMachine turingMachine = new TuringMachine(strip, "q1", rules);
        int currentStep = 0;
        do {
            TransitionValue transitionValue = turingMachine.doStep();
            System.out.printf("step #%d%n", currentStep++);
            System.out.println(strip);
            System.out.println("new state: " + transitionValue.getNewState());
            System.out.println();
        } while (!turingMachine.isStopped());
    }
}
