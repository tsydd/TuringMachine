/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class TransitionValue {
    private char newValue;
    private Direction direction;
    private String newState;

    public TransitionValue(String newState, char newValue, Direction direction) {
        this.newValue = newValue;
        this.direction = direction;
        this.newState = newState;
    }

    public char getNewValue() {
        return newValue;
    }

    public void setNewValue(char newValue) {
        this.newValue = newValue;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }
}
