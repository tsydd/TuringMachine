/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class TransitionKey {
    private String state;
    private char value;

    public TransitionKey(String state, char value) {
        this.state = state;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransitionKey that = (TransitionKey) o;

        if (value != that.value) return false;
        if (!state.equals(that.state)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + (int) value;
        return result;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
