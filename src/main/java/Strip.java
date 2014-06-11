/**
 * @author Dmitry Tsydzik
 * @since Date: 11.06.2014
 */
public interface Strip<T> {

    T getCurrent();

    void setCurrent(T value);

    void moveLeft();

    void moveRight();
}
