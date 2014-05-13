
/**
 * Created by Michael on 2/14/2014.
 */
public class KeyEvent extends Event {
    enum EventType { KEYPRESS, KEYRELEASE }

    EventType type;
    char key; // only set if type is key

    KeyEvent ( char c, EventType type ) {
        this.key = c;
        this.type = type;
    }

    void SetKey( char c ) {
        this.key = c;
    }

    char GetKey() {
        return this.key;
    }

    EventType GetType () {
        return this.type;
    }

}
