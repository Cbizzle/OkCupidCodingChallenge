package xyz.flo.okcupidchallenge.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.AndroidSupportInjection;
import xyz.flo.okcupidchallenge.BR;
import xyz.flo.okcupidchallenge.R;
import xyz.flo.okcupidchallenge.databinding.FragmentTopMatchBinding;
import xyz.flo.okcupidchallenge.viewmodel.OkCupidViewModel;

/**
 * Fragment that hosts a recyclerview to show off the top matches of users liked
 */
public class TopMatchFragment extends Fragment {
    private FragmentTopMatchBinding fragmentTopMatchBinding;
    private OkCupidViewModel okCupidViewModel;

    @Inject
    @Named("span_2_grid")
    LinearLayoutManager recyclerViewLayoutManager;

    @Inject
    TopMatchAdapter topMatchAdapter;

    public static TopMatchFragment createInstance() {
        Bundle args = new Bundle();
        TopMatchFragment topMatchFragment = new TopMatchFragment();
        topMatchFragment.setArguments(args);
        return topMatchFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        okCupidViewModel = ViewModelProviders.of(this.getActivity()).get(OkCupidViewModel.class);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTopMatchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_match, container, false);
        return fragmentTopMatchBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentTopMatchBinding.setVariable(BR.viewModel, okCupidViewModel);
        fragmentTopMatchBinding.executePendingBindings();

        //Setup Recyclerview
        fragmentTopMatchBinding.topMatchRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        fragmentTopMatchBinding.topMatchRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentTopMatchBinding.topMatchRecyclerView.setAdapter(topMatchAdapter);

        okCupidViewModel.getTopMatches().observe(this, users -> topMatchAdapter.addUsers(users));
    }
}
