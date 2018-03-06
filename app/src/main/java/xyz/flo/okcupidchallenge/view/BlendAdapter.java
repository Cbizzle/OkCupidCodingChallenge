package xyz.flo.okcupidchallenge.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import xyz.flo.okcupidchallenge.data.User;
import xyz.flo.okcupidchallenge.databinding.ItemUserViewBinding;
import xyz.flo.okcupidchallenge.viewmodel.LikeClickListener;
import xyz.flo.okcupidchallenge.viewmodel.UserBlendItemViewModel;

/**
 * A Recyclerview adapter for the blend of OKCupid Users and to display OkCupid User data
 */
public class BlendAdapter extends RecyclerView.Adapter<BlendAdapter.UserItemViewHolder> {

    private List<User> users;

    private LikeClickListener likeClickListener;

    public BlendAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserViewBinding itemUserViewBinding = ItemUserViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserItemViewHolder(itemUserViewBinding);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
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

    public void setLikeClickListener(LikeClickListener likeClickListener) {
        this.likeClickListener = likeClickListener;
    }

    class UserItemViewHolder extends BaseViewHolder {

        private ItemUserViewBinding itemUserViewBinding;
        private UserBlendItemViewModel userItemViewModel;

        UserItemViewHolder(ItemUserViewBinding itemUserViewBinding) {
            super(itemUserViewBinding.getRoot());
            this.itemUserViewBinding = itemUserViewBinding;
        }

        @Override
        public void onBind(int position) {
            final User user = users.get(position);
            userItemViewModel = new UserBlendItemViewModel(user, likeClickListener);
            itemUserViewBinding.setViewModel(userItemViewModel);
            itemUserViewBinding.executePendingBindings();
        }
    }

}
