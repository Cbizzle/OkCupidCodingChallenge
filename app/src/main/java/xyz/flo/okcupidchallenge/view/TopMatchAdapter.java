package xyz.flo.okcupidchallenge.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import xyz.flo.okcupidchallenge.data.User;
import xyz.flo.okcupidchallenge.databinding.ItemTopUserViewBinding;
import xyz.flo.okcupidchallenge.viewmodel.UserItemViewModel;

/**
 * A Recyclerview adapter for the top matches of OKCupid Users and to display OkCupid User data
 */
public class TopMatchAdapter extends RecyclerView.Adapter<TopMatchAdapter.TopMatchViewHolder> {

    private List<User> users;

    public TopMatchAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public TopMatchAdapter.TopMatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTopUserViewBinding itemTopUserViewBinding = ItemTopUserViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TopMatchAdapter.TopMatchViewHolder(itemTopUserViewBinding);
    }

    @Override
    public void onBindViewHolder(TopMatchAdapter.TopMatchViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        }

        return 0;
    }

    /**
     * @param users The list of users to be shown on the recyclerview
     *              This will notify the recyclerview that the data has updated and to update the views
     */
    public void addUsers(List<User> users) {
        if(users != null && !users.isEmpty()) {
            this.users.clear();
            this.users.addAll(users);
            notifyDataSetChanged();
        }
    }

    class TopMatchViewHolder extends BaseViewHolder {

        private ItemTopUserViewBinding itemTopUserViewBinding;
        private UserItemViewModel userItemViewModel;

        TopMatchViewHolder(ItemTopUserViewBinding itemUserViewBinding) {
            super(itemUserViewBinding.getRoot());
            this.itemTopUserViewBinding = itemUserViewBinding;
        }

        @Override
        public void onBind(int position) {
            final User user = users.get(position);
            userItemViewModel = new UserItemViewModel(user);
            itemTopUserViewBinding.setViewModel(userItemViewModel);
            itemTopUserViewBinding.executePendingBindings();

        }
    }

}
