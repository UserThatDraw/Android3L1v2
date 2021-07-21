package com.example.android3l1v2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3l1v2.databinding.FragmentListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {


    private RecyclerAdapter adapter = new RecyclerAdapter();
    FragmentListBinding listBinding;
    private MViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listBinding = FragmentListBinding.inflate(inflater, container, false);
        return listBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setRecycler();
        setObserve();
        setListener();
    }



    private void setObserve() {
        viewModel.listM.observe(getViewLifecycleOwner(), new Observer<List<BookModel>>() {
            @Override
            public void onChanged(List<BookModel> bookModels) {
                adapter.setIn(bookModels);
            }
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(MViewModel.class);
    }

    private void setListener() {
        setBtnOpenRec();
        openAboutFragment();
    }

    private void openAboutFragment() {
        adapter.setOnClick(new OnClick() {
            @Override
            public void getSmt(BookModel model) {

            }
        });
    }

    private void setBtnOpenRec() {
        listBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBinding.btn.setVisibility(View.GONE);
                viewModel.addAll();
            }
        });
    }

    private void setRecycler() {
        listBinding.frameLay.setLayoutManager(new LinearLayoutManager(getActivity()));
        listBinding.frameLay.setAdapter(adapter);

    }
}