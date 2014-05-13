package pennapps.project;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity implements ActionBar.OnNavigationListener {

    private RelativeLayout layout;
    private KeyButton up, down, left, right;
    private PrintWriter printWriter;
    private Socket socket;

    // action bar
    private ActionBar actionBar;

    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;

    // Navigation adapter
    private TitleNavigationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        actionBar = getActionBar();

        // Hide the action bar title
        actionBar.setDisplayShowTitleEnabled(false);

        // Enabling Spinner dropdown navigation
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("Local", R.drawable.ic_action_settings));
        navSpinner.add(new SpinnerNavItem("My Places", R.drawable.ic_launcher));
        navSpinner.add(new SpinnerNavItem("Checkins", R.drawable.ic_action_new));
        navSpinner.add(new SpinnerNavItem("Latitude", R.drawable.ic_launcher));

        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);

        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(adapter, this);

        layout = new RelativeLayout(getApplicationContext());
        up = new KeyButton(getApplicationContext(), KeyEvent.VK_UP);
        down = new KeyButton(getApplicationContext(), KeyEvent.VK_DOWN);
        left = new KeyButton(getApplicationContext(), KeyEvent.VK_LEFT);
        right = new KeyButton(getApplicationContext(), KeyEvent.VK_RIGHT);

        RelativeLayout.LayoutParams r = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                        ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(r);

        RelativeLayout.LayoutParams t = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        t.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        t.addRule(RelativeLayout.RIGHT_OF, left.getId());
        up.setLayoutParams(t);

        RelativeLayout.LayoutParams q = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        q.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        //q.addRule(RelativeLayout.LEFT_OF, down.getId());
        q.addRule(RelativeLayout.BELOW, up.getId());
        left.setLayoutParams(q);

        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        p.addRule(RelativeLayout.BELOW, up.getId());
        p.addRule(RelativeLayout.RIGHT_OF, left.getId());
        down.setLayoutParams(p);

        RelativeLayout.LayoutParams s = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        s.addRule(RelativeLayout.RIGHT_OF, down.getId());
        s.addRule(RelativeLayout.BELOW, up.getId());
        right.setLayoutParams(s);

        layout.addView(up);
        layout.addView(right);
        layout.addView(left);
        layout.addView(down);

        layout.setBackgroundColor(Color.BLUE);

        layout.setVisibility(View.VISIBLE);
        up.setVisibility(View.VISIBLE);
        down.setVisibility(View.VISIBLE);
        left.setVisibility(View.VISIBLE);
        right.setVisibility(View.VISIBLE);

        setContentView(layout);
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
                Log.i("MainActivity", "startLayout");
                Toast.makeText(getApplicationContext(), "Layout Maker", Toast.LENGTH_SHORT).show();
                Intent startNewActivityOpen = new Intent(MainActivity.this, LayoutMaker.class);
                startActivityForResult(startNewActivityOpen, 0);
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Actionbar navigation item select listener
     * */
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // Action to be taken after selecting a spinner item
        return false;
    }

}