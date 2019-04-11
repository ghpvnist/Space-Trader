package edu.gatech.cs2340.spacetrader.model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutionException;

import edu.gatech.cs2340.spacetrader.model.GameData;

import static android.content.Context.MODE_PRIVATE;

/**
 * Facade that handles the loading and saving of the gameData singleton
 */
public class GameDataFacade {

    /**
     * Async method that saves the gameData object to a file
     * @param context the context of the current activity
     * @throws ExecutionException throws if the method cannot be executed
     * @throws InterruptedException throws if the async task is interrupted
     */
    public void saveGameData(Context context) throws ExecutionException, InterruptedException {
        new SaveOperation().execute(context).get();
        Log.i("Data", "Finished Waiting");
    }

    /**
     * Loads the gameData object from the file
     * @param context the context of the current activity
     * @throws FileNotFoundException throws if we cannot find the file to load from
     * @throws IOException throws if there is some problem with the input stream
     * @throws ClassNotFoundException throws if we cannot cast the file data to the gameData type
     */
    public void loadGameData(Context context) throws FileNotFoundException, IOException, ClassNotFoundException{
        Log.i("Data", "Called Method");
        FileInputStream fis = context.openFileInput("data.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        Log.i("Data", "Opened Streams");
        GameData gameData = (GameData) is.readObject();
        GameData.getInstance().setPlayer(gameData.getPlayer());
        GameData.getInstance().setUniverse(gameData.getUniverse());
        Log.i("Data", "Loaded From File");
        is.close();
        fis.close();
    }

    private class SaveOperation extends AsyncTask<Context, Void, String>{

        @Override
        protected String doInBackground(Context... contexts) {
            GameData gameData = GameData.getInstance();
            Log.i("Data", "Called Method");
            try {
                FileOutputStream fos = contexts[0].openFileOutput("data.txt", MODE_PRIVATE);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                Log.i("Data", "Opened Streams");
                os.writeObject(gameData);
                Log.i("Data", "Saved to File");
                os.close();
                fos.close();
            } catch(Exception e) {

            }
            return "Completed";
        }
    }

}
