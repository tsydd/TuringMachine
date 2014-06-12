/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public class StringBuilderBasedStrip implements Strip<Character> {
    private StringBuilder stringBuilder;
    private int position = 0;

    public StringBuilderBasedStrip(String string) {
        stringBuilder = new StringBuilder(string);
    }

    @Override
    public Character getCurrent() {
        return stringBuilder.charAt(position);
    }

    @Override
    public void setCurrent(Character value) {
        while (position >= stringBuilder.length()) {
            stringBuilder.append(' ');
        }
        while (position < 0) {
            stringBuilder.insert(0, ' ');
            position++;
        }
        stringBuilder.setCharAt(position, value);
    }

    @Override
    public void moveLeft() {
        position--;
    }

    @Override
    public void moveRight() {
        position++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(stringBuilder);
        result.append("\n");
        for (int i = 0; i < position; i++) {
            result.append(' ');
        }
        result.append('^');
        return result.toString();
    }
}
