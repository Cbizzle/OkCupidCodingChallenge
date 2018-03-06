package xyz.flo.okcupidchallenge.tasks;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;

import xyz.flo.okcupidchallenge.data.OkCupidData;
import xyz.flo.okcupidchallenge.utils.SerializerUtils;


/**
 * An asynchronous task to retrieve user data from a simple JSON file.
 */
public class OkCupidAsyncTask extends AsyncTask<Void, Void, OkCupidData> {

    private String url;
    private OkCupidTaskListener okCupidPostTaskListener;

    public OkCupidAsyncTask(String url, OkCupidTaskListener okCupidTaskListener) {
        this.url = url;
        this.okCupidPostTaskListener = okCupidTaskListener;
    }

    @Override
    protected OkCupidData doInBackground(Void... voids) {
        try {
            String okCupidDataString = IOUtils.toString(URI.create((url)));
            return SerializerUtils.OBJECT_MAPPER.readValue(okCupidDataString, OkCupidData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(OkCupidData okCupidData) {
        okCupidPostTaskListener.onFinished(okCupidData);
    }
}
