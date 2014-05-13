package pennapps.project;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 * Created by Michael on 2/15/2014.
 */
public class Network extends AsyncTask<Event, Void, Void> {

    private Socket socket;
    private ObjectOutputStream objOutput;
    @Override
    protected Void doInBackground(Event... event) {
        try {
            // may cause lag
            socket = new Socket("158.130.161.251", 14444);
            objOutput = new ObjectOutputStream(socket.getOutputStream());
            objOutput.writeObject(event[0]);
            objOutput.flush();
            objOutput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
