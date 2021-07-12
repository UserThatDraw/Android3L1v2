package com.example.android3l1v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3l1v2.databinding.FragmentListBinding;

import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView rvBook;
    private RecyclerAdapter adapter;
    List<BookModel> list;
    FragmentListBinding listBinding;
    private MViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initi();

    }

    private void initi() {
        adapter = new RecyclerAdapter(list, getActivity());
        listBinding.frameLay.setLayoutManager(new LinearLayoutManager(getContext()));
        listBinding.frameLay.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(MViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listBinding = FragmentListBinding.inflate(inflater, container, false);
        listBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBinding.btn.setVisibility(View.GONE);
                viewModel.addAll();
            }
        });

        return listBinding.getRoot();
    }
}