package com.example.android3l1v2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3l1v2.base.BaseFragment;
import com.example.android3l1v2.databinding.FragmentAboutBinding;

import org.jetbrains.annotations.NotNull;

public class AboutFragment extends BaseFragment <FragmentAboutBinding> {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected void initialize() {
        setupDescription();
    }

    private void setupDescription() {
        BookModel model = AboutFragmentArgs.fromBundle(getArguments()).getBookDesc();
        binding.headerTxt.setText(model.getTitle());
        binding.descTxt.setText(model.getDescr());
        binding.backImage.setImageResource(model.getIcon());
    }
}
