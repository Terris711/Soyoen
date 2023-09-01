package com.example.fragments_week4;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private NoteTakingFragment noteTakingFragment;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        Button addNoteButton = rootView.findViewById(R.id.addNoteButton);

        if (NoteViewModel.isNoteSaved()) {
            addNoteButton.setText("Edit Note");
        } else {
            addNoteButton.setText("Add New Note");
        }

        addNoteButton.setOnClickListener(v -> {
            noteTakingFragment = new NoteTakingFragment();

            // Load NoteTakingFragment for editing if a note is saved, otherwise for adding
            if (NoteViewModel.isNoteSaved()) {
                loadEditNoteFragment();
            } else {
                loadAddNoteFragment();
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Determine the screen orientation
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            loadNoteTakingFragment();
        }
    }

    private void loadEditNoteFragment() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, noteTakingFragment)
                .commit();
    }

    private void loadAddNoteFragment() {
        noteTakingFragment = new NoteTakingFragment();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, noteTakingFragment)
                .commit();
    }

    private void loadNoteTakingFragment() {
        noteTakingFragment = new NoteTakingFragment();

        // Check if NoteTakingFragment is already added to avoid duplication
        if (!noteTakingFragment.isAdded()) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.noteFragmentContainer, noteTakingFragment)
                    .commit();
        }
    }

}
