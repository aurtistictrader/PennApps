package pennapps.project;



/**
 * Created by Michael on 2/14/2014.
 */
public class MouseEvent extends Event {
    static final long serialVersionUID = 1L;
    enum EventType { MOUSEDOWN, MOUSEUP, MOUSEMOVE}; 
    private int type;
    private Point point; /* only set for mouse type
                    position of the cursor */
    MouseEvent() {
        type = 1;
        point = new Point(0, 0);
    }

    MouseEvent ( int type, Point point ) {
        this.type = type;
        this.point = point;
    }
    public int GetKey() {
        return 0;
    }
    
    public int GetType() {
        return this.type;
    }
    
    public Point GetPoint() {
        return point;
    }

}
