package xyz.flo.okcupidchallenge.tasks;

/**
 * An synctask listener that alerts on finished
 * @param <T>
 */
public interface TaskListener<T> {

    void onFinished(T response);
}
