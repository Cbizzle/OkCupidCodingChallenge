package xyz.flo.okcupidchallenge.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
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
import xyz.flo.okcupidchallenge.databinding.FragmentBlendBinding;
import xyz.flo.okcupidchallenge.viewmodel.OkCupidViewModel;


/**
 * Fragment that hosts a recyclerview to show off a random assortment of users matched to you
 */
public class BlendFragment extends Fragment {

    private FragmentBlendBinding fragmentBlendBinding;
    private OkCupidViewModel okCupidViewModel;

    @Inject
    @Named("span_2_grid")
    LinearLayoutManager recyclerViewLayoutManager;

    @Inject
    BlendAdapter blendAdapter;

    public static BlendFragment createInstance() {
        Bundle args = new Bundle();
        BlendFragment blendFragment = new BlendFragment();
        blendFragment.setArguments(args);
        return blendFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        okCupidViewModel = ViewModelProviders.of(this.getActivity()).get(OkCupidViewModel.class);

        blendAdapter.setLikeClickListener(okCupidViewModel.getLikeListener());

        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentBlendBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_blend, container, false);
        return fragmentBlendBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentBlendBinding.setVariable(BR.viewModel, okCupidViewModel);
        fragmentBlendBinding.executePendingBindings();

        //Setup Recyclerview
        fragmentBlendBinding.blendRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        fragmentBlendBinding.blendRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentBlendBinding.blendRecyclerView.setAdapter(blendAdapter);

        //Observe on the blend users
        okCupidViewModel.getUsers().observe(this, users -> blendAdapter.addUsers(users));
    }

}
