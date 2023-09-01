package com.example.fragments_week4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class NoteTakingFragment extends Fragment {

    private EditText titleEditText;
    private EditText detailsEditText;
    private NoteViewModel noteViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_note_taking, container, false);

        // Initialize views
        titleEditText = rootView.findViewById(R.id.titleEditText);
        detailsEditText = rootView.findViewById(R.id.detailsEditText);
        Button saveButton = rootView.findViewById(R.id.saveButton);

        // Get the ViewModel
        noteViewModel = new ViewModelProvider(requireActivity()).get(NoteViewModel.class);

        // Set up click listener for the save button
        saveButton.setOnClickListener(view -> saveNote());

        // Populate fields with existing note if available
        String existingTitle = noteViewModel.getNoteTitle();
        String existingDetails = noteViewModel.getNoteDetails();
        if (existingTitle != null) {
            titleEditText.setText(existingTitle);
        }
        if (existingDetails != null) {
            detailsEditText.setText(existingDetails);
        }

        return rootView;
    }

    private void saveNote() {
        String title = titleEditText.getText().toString();
        String details = detailsEditText.getText().toString();
        noteViewModel.setNoteTitle(title);
        noteViewModel.setNoteDetails(details);
        noteViewModel.setNoteSaved(true);

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) requireActivity()).loadMenuFragment(); // Load MenuFragment
        }
    }
}
