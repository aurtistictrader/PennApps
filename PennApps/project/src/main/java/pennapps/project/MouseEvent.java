package pennapps.project;

import java.io.Serializable;

/**
 * Created by Michael on 2/14/2014.
 */
public class MouseEvent extends Event {
    static final long serialVersionUID = 1L;
    private int type;
    private Point point;

    public MouseEvent() {
        this.type = 1;
        this.point = new Point(0, 0);
    }

    public MouseEvent ( int type, Point point ) {
        this.type = type;
        this.point = point;
    }

    int GetKey() {
        return 0;
    }

    int GetType() {
        return this.type;
    }

    Point GetPoint() {
        return point;
    }
}
