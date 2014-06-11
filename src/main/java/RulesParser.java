import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class RulesParser {
    public Map<TransitionKey, TransitionValue> parseRules(Reader reader) {
        Map<TransitionKey, TransitionValue> result = new HashMap<>();
        try (Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                String startState = scanner.next();
                char value = scanner.next().charAt(0);

                scanner.next();

                String newState = scanner.next();
                char newValue = scanner.next().charAt(0);
                String directionString = scanner.next();

                Direction direction;
                switch (directionString) {
                    case "R":
                        direction = Direction.RIGHT;
                        break;
                    case "L":
                        direction = Direction.LEFT;
                        break;
                    default:
                        direction = Direction.X;
                }

                result.put(new TransitionKey(startState, value), new TransitionValue(newState, newValue, direction));
            }
        }
        return result;
    }
}
