package xyz.flo.okcupidchallenge.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds the view data based on the position
     * @param position
     */
    public abstract void onBind(int position);
}
