package pennapps.project;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View.DragShadowBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View.OnDragListener;
import android.view.DragEvent;
import android.content.Context;
import android.content.ClipData;
import android.content.ClipDescription;
import android.app.AlertDialog;
import android.app.ActionBar;
import java.util.ArrayList;

/**
 * Created by Michael on 2/15/2014.
 */
public class LayoutMaker extends Activity {
    private KeyButton newBtn;
    private LinearLayout scrollBar, parentLayer;
    private GridLayout layoutMaker;
    private Button w;
    private static ArrayList<Button> widgetButtons = new ArrayList<Button>();


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        parentLayer = new LinearLayout(LayoutMaker.this);

        scrollBar = new LinearLayout(LayoutMaker.this);
        layoutMaker = new GridLayout(LayoutMaker.this);

        layoutMaker.setRowCount(4);
        layoutMaker.setColumnCount(3);
        layoutMaker.setPadding(17, 0, 0, 0);

        parentLayer.setOrientation(LinearLayout.VERTICAL);

        w = new Button(LayoutMaker.this);
        w.setText("Add Button");
        w.setHint("AddBtn");

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        parentLayer.setLayoutParams(layout);

        LinearLayout.LayoutParams widgetPanel = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.2F);

        scrollBar.setLayoutParams(widgetPanel);

        LinearLayout.LayoutParams widget = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        widget.topMargin = 40;
        w.setLayoutParams(widget);

        LinearLayout.LayoutParams layoutPanel = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.8F);

        layoutPanel.gravity = RelativeLayout.ALIGN_PARENT_TOP;
        layoutPanel.gravity = RelativeLayout.ALIGN_PARENT_LEFT;

        scrollBar.setBackgroundColor(Color.CYAN);
        scrollBar.setLayoutParams(widgetPanel);
        layoutMaker.setBackgroundColor(Color.DKGRAY);
        layoutMaker.setLayoutParams(layoutPanel);

        scrollBar.addView(w);

        w.setVisibility(View.VISIBLE);

        layoutMaker.setVisibility(View.VISIBLE);
        scrollBar.setVisibility(View.VISIBLE);

        parentLayer.addView(layoutMaker);
        parentLayer.addView(scrollBar);
        parentLayer.setVisibility(View.VISIBLE);

        setContentView(parentLayer);

        w.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // create it from the object's tag
                ClipData.Item item = new ClipData.Item((CharSequence) w.getHint());

                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData(w.getHint().toString(), mimeTypes, item);
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(w);

                w.startDrag(data, //data to be dragged
                        shadowBuilder, //drag shadow
                        w, //local data about the drag and drop operation
                        0   //no needed flags
                );

                scrollBar.setOnDragListener(new MyDragListener());
                layoutMaker.setOnDragListener(new MyDragListener());
                return false;
            }
        });
        //////////////////
        //rest of the code

        //widgetBtn = (ImageView);
        /*widgetBtn.setTag("Initiate widget");
        widgetBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // drag and move the button
                Log.d("LayoutMaker", "button long pressed --> ");

                // Copy ScrollView Object (for reverting after drag and drop)
                //scrollBar = ;

                layoutMaker.setOnDragListener(new MyDragListener());
                //(R.id.layout_panel).setOnDragListener(new MyDragListener());

                // create it from the object's tag
                ClipData.Item item = new ClipData.Item((CharSequence) widgetBtn.getTag());

                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData(widgetBtn.getTag().toString(), mimeTypes, item);
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(widgetBtn);

                widgetBtn.startDrag(data, //data to be dragged
                        shadowBuilder, //drag shadow
                        widgetBtn, //local data about the drag and drop operation
                        0   //no needed flags
                );

                v.setVisibility(View.INVISIBLE);

                return true;
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch ( item.getItemId() ) {
            case R.id.add_layout:
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyDragListener implements OnDragListener {
        int targetShape = R.color.darkGrey;
        int normalShape = R.color.orange;

        @Override
        public boolean onDrag(View v, DragEvent event) {
            Log.d("LayoutMaker", "onDrag");

            // Handles each of the expected events
            switch (event.getAction()) {
                //signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;

                //the drag point has entered the bounding box of the View
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(targetShape);   //change the shape of the view
                    break;
                //the user has moved the drag shadow outside the bounding box of the View
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(normalShape);   //change the shape of the view back to normal
                    break;
                //drag shadow has been released,the drag point is within the bounding box of the View
                case DragEvent.ACTION_DROP:
                    // if the view is the bottomlinear, we accept the drag item
                    if(v == layoutMaker) {

                        View view = (View) event.getLocalState();
                        //ViewGroup viewgroup = (ViewGroup) view.getParent();

                        Log.d("LayoutMaker", "The item is dropped");
                        GridLayout containView = (GridLayout) v;

                        AlertDialog.Builder alert = new AlertDialog.Builder(LayoutMaker.this);

                        alert.setTitle("Please select a key");

                        // Set an EditText view to get user input
                        final EditText input = new EditText(LayoutMaker.this);

                        InputFilter [] filter = new InputFilter[1];
                        filter[0] = new InputFilter.LengthFilter(5);
                        input.setFilters(filter);
                        input.setHeight(50);
                        input.setWidth(100);
                        alert.setView(input);

                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String butt = input.getText().toString().toUpperCase();
                                int in = KeyEvent.keyMap.get(butt.toString());
                                newBtn.setText(butt);
                                newBtn.setKey(in);
                            }
                        });

                        input.setVisibility(View.VISIBLE);
                        alert.show();

                        newBtn = new KeyButton(LayoutMaker.this);

                        containView.addView(newBtn);
                        newBtn.setVisibility(View.VISIBLE);
                    } else {
                        View view = (View) event.getLocalState();
                        v.setBackgroundColor(normalShape);   //go back to normal shape

                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "You can't drop the image here",
                                Toast.LENGTH_LONG).show();
                        break;
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundColor(normalShape);   //go back to normal shape

                default:
                    v.setBackgroundColor(normalShape);   //go back to normal shape
                    System.out.println(v);
                    break;
            }
            return true;
        }
    }

}
