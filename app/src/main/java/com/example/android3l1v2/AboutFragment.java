package com.example.android3l1v2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android3l1v2.databinding.FragmentAboutBinding;
import com.example.android3l1v2.databinding.FragmentListBinding;

import org.jetbrains.annotations.NotNull;

public class AboutFragment extends Fragment {
    FragmentAboutBinding aboutBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        aboutBinding = FragmentAboutBinding.inflate(inflater, container, false);
        return aboutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupDescription();
    }

    private void setupDescription() {
        BookModel model = AboutFragmentArgs.fromBundle(getArguments()).getBookDesc();
        aboutBinding.headerTxt.setText(model.getTitle());
        aboutBinding.descTxt.setText(model.getDescr());
        aboutBinding.backImage.setImageResource(model.getIcon());
    }
}
