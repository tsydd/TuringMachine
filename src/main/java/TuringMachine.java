import java.util.Map;

/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class TuringMachine {

    public static final String FINAL_STATE = "q0";

    private Strip<Character> strip;
    private String state;
    private Map<TransitionKey, TransitionValue> rules;
    private boolean stopped = false;

    public TuringMachine(Strip<Character> strip, String initialState, Map<TransitionKey, TransitionValue> rules) {
        this.strip = strip;
        this.state = initialState;
        this.rules = rules;
    }

    public TransitionValue doStep() {
        if (stopped) {
            throw new RuntimeException("machine is already stopped");
        }
        char currentValue = strip.getCurrent();
        TransitionValue result = rules.get(new TransitionKey(state, currentValue));
        if (result == null) {
            throw new RuntimeException(String.format("no transition for state [%s, %s]", state, currentValue));
        }
        strip.setCurrent(result.getNewValue());
        state = result.getNewState();
        if (FINAL_STATE.equals(state)) {
            stopped = true;
        }
        switch (result.getDirection()) {
            case LEFT:
                strip.moveLeft();
                break;
            case RIGHT:
                strip.moveRight();
        }
        return result;
    }

    public boolean isStopped() {
        return stopped;
    }
}
