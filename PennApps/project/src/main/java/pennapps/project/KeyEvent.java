package pennapps.project;

import android.util.Pair;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Michael on 2/14/2014.
 */
public class KeyEvent extends Event {

    public static final int	VK_0 =	48;
    public static final int	VK_1 =	49;
    public static final int	VK_2 =	50;
    public static final int	VK_3 =	51;
    public static final int	VK_4 =	52;
    public static final int	VK_5 =	53;
    public static final int	VK_6 =	54;
    public static final int	VK_7 =	55;
    public static final int	VK_8 =	56;
    public static final int	VK_9 =	57;
    public static final int	VK_ENTER = 10;
    public static final int	VK_DOWN = 40;
    public static final int	VK_UP = 38;
    public static final int	VK_LEFT = 37;
    public static final int	VK_RIGHT = 39;
    public static final int	VK_NUMPAD0 = 96;
    public static final int	VK_NUMPAD1 = 97;
    public static final int	VK_NUMPAD2 = 98;
    public static final int	VK_NUMPAD3 = 99;
    public static final int	VK_NUMPAD4 = 100;
    public static final int	VK_NUMPAD5 = 101;
    public static final int	VK_NUMPAD6 = 102;
    public static final int	VK_NUMPAD7 = 103;
    public static final int	VK_NUMPAD8 = 104;
    public static final int	VK_NUMPAD9 = 105;
    public static final int	VK_SPACE = 32;
    public static final int	VK_A = 65;
    public static final int	VK_B = 66;
    public static final int	VK_C = 67;
    public static final int	VK_D = 68;
    public static final int	VK_E = 69;
    public static final int	VK_F = 70;
    public static final int	VK_G = 71;
    public static final int	VK_H = 72;
    public static final int	VK_I = 73;
    public static final int	VK_J = 74;
    public static final int	VK_K = 75;
    public static final int	VK_L = 76;
    public static final int	VK_M = 77;
    public static final int	VK_N = 78;
    public static final int	VK_O = 79;
    public static final int	VK_P = 80;
    public static final int	VK_Q = 81;
    public static final int	VK_R = 82;
    public static final int	VK_S = 83;
    public static final int	VK_T = 84;
    public static final int	VK_U = 85;
    public static final int	VK_V = 86;
    public static final int	VK_W = 87;
    public static final int	VK_X = 88;
    public static final int	VK_Y = 89;
    public static final int	VK_Z = 90;


    public static final HashMap<String, Integer> keyMap = new HashMap<String, Integer>();
    static {
        keyMap.put("0", VK_0);
        keyMap.put("1", VK_1);
        keyMap.put("2", VK_2);
        keyMap.put("3", VK_3);
        keyMap.put("4", VK_4);
        keyMap.put("5", VK_5);
        keyMap.put("6", VK_6);
        keyMap.put("7", VK_7);
        keyMap.put("8", VK_8);
        keyMap.put("9", VK_9);
        keyMap.put("A", VK_A);
        keyMap.put("B", VK_B);
        keyMap.put("C", VK_C);
        keyMap.put("D", VK_D);
        keyMap.put("E", VK_E);
        keyMap.put("F", VK_F);
        keyMap.put("G", VK_G);
        keyMap.put("H", VK_H);
        keyMap.put("I", VK_I);
        keyMap.put("J", VK_J);
        keyMap.put("K", VK_K);
        keyMap.put("L", VK_L);
        keyMap.put("M", VK_M);
        keyMap.put("N", VK_N);
        keyMap.put("O", VK_O);
        keyMap.put("P", VK_P);
        keyMap.put("Q", VK_Q);
        keyMap.put("R", VK_R);
        keyMap.put("S", VK_S);
        keyMap.put("T", VK_T);
        keyMap.put("U", VK_U);
        keyMap.put("V", VK_V);
        keyMap.put("W", VK_W);
        keyMap.put("X", VK_X);
        keyMap.put("Y", VK_Y);
        keyMap.put("Z", VK_Z);
        keyMap.put("ENTER", VK_ENTER);
        keyMap.put("UP", VK_UP);
        keyMap.put("DOWN", VK_DOWN);
        keyMap.put("LEFT", VK_LEFT);
        keyMap.put("RIGHT", VK_RIGHT);
        keyMap.put("NUM0", VK_0);
        keyMap.put("NUM1", VK_1);
        keyMap.put("NUM2", VK_2);
        keyMap.put("NUM3", VK_3);
        keyMap.put("NUM4", VK_4);
        keyMap.put("NUM5", VK_5);
        keyMap.put("NUM6", VK_6);
        keyMap.put("NUM7", VK_7);
        keyMap.put("NUM8", VK_8);
        keyMap.put("NUM9", VK_9);
        keyMap.put("SPACE", VK_SPACE);
    }

    static final long serialVersionUID = 1L;
    private int type;
    private int key; // only set if type is key

    KeyEvent ( int type, int c ) {
        this.key = c;
        this.type = type;
    }

    public void SetKey( char c ) {
        this.key = c;
    }

    public int GetKey() {
        return this.key;
    }

    public int GetType () {
        return this.type;
    }

}
