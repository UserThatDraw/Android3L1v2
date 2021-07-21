package com.example.android3l1v2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3l1v2.base.BaseFragment;
import com.example.android3l1v2.databinding.FragmentListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends BaseFragment <FragmentListBinding> {


    private RecyclerAdapter adapter = new RecyclerAdapter();
    private MViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    private void openAboutFragment() {
        adapter.setOnClick(new OnClick() {
            @Override
            public void getSmt(BookModel model, View view) {
                Navigation.findNavController(view).navigate(ListFragmentDirections.actionListFragment4ToAboutFragment2(model).setBookDesc(model));
            }
        });
    }

    private void setBtnOpenRec() {
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btn.setVisibility(View.GONE);
                viewModel.addAll();
            }
        });
    }

    private void setRecycler() {
        binding.frameLay.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.frameLay.setAdapter(adapter);

    }

    @Override
    protected void setObserve() {
        viewModel.listM.observe(getViewLifecycleOwner(), new Observer<List<BookModel>>() {
            @Override
            public void onChanged(List<BookModel> bookModels) {
                binding.btn.setVisibility(View.GONE);
                adapter.setIn(bookModels);
            }
        });
    }

    @Override
    protected void setListener() {
        setBtnOpenRec();
        openAboutFragment();
    }

    @Override
    protected void setupViews() {
        setRecycler();
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(MViewModel.class);
    }
}