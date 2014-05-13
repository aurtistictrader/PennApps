package pennapps.project;

import android.view.*;
import android.widget.Button;
import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Michael on 2/15/2014.
 */
public class KeyButton extends Button {

    private int key;
    public static int freeID = 1;

    public KeyButton (Context context) {
        super(context);
        this.key = -1;
        initButton();
    }

    public KeyButton (Context context, int key) {
        super(context);
        this.key = key;
        initButton();
    }

    public KeyButton(Context context, int key, AttributeSet attrs) {
        super(context, attrs);
        this.key = key;
        initButton();
    }

    public KeyButton(Context context, AttributeSet attrs, int key, int defStyle) {
        super(context, attrs, defStyle);
        this.key = key;
        initButton();
    }

    public void setKey(int key) {
        this.key = key;
        this.setOnClickListener(null);
        setKeyListener();
    }

    public int getKey() {
        return this.key;
    }

    public void initButton() {
        this.setId(freeID);
        freeID++;
        setKeyListener();
        setText();
        setHeight(350);
        setWidth(350);
    }

    public void setKeyListener() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                new Network().execute(new pennapps.project.KeyEvent(1, key));
            }
        });
    }

    private void setText() {
        switch(key) {
            case KeyEvent.VK_UP:
                setText("UP");
                break;
            case KeyEvent.VK_DOWN:
                setText("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                setText("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                setText("RIGHT");
                break;
            case KeyEvent.VK_SPACE:
                setText("SPACE");
                break;
            default:
                setText(String.valueOf(key));
        }
    }
}
