/*
 *  Copyright (c) 2020 mohb apps - All Rights Reserved
 *
 *  Project       : ShutterNotes
 *  Developer     : Haraldo Albergaria Filho, a.k.a. mohb apps
 *
 *  File          : DeleteAllNotesAlertFragment.java
 *  Last modified : 10/11/20 3:13 PM
 *
 *  -----------------------------------------------------------
 */

package com.apps.mohb.shutternotes.fragments.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.apps.mohb.shutternotes.R;


public class DeleteAllNotesAlertFragment extends DialogFragment {

    public interface DeleteAllNotesAlertDialogListener {
        void onDeleteAllNotesDialogPositiveClick(DialogFragment dialog);

        void onDeleteAllNotesDialogNegativeClick(DialogFragment dialog);
    }

    private DeleteAllNotesAlertDialogListener mListener;


    @NonNull
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alert_title_delete_all_notes).setMessage(R.string.alert_message_no_undone)
                .setPositiveButton(R.string.alert_button_yes, (dialog, id) -> mListener.onDeleteAllNotesDialogPositiveClick(DeleteAllNotesAlertFragment.this))
                .setNegativeButton(R.string.alert_button_no, (dialog, id) -> mListener.onDeleteAllNotesDialogNegativeClick(DeleteAllNotesAlertFragment.this));

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the DeleteAllNotesDialogListener so we can send events to the host
            mListener = (DeleteAllNotesAlertDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement DeleteAllNotesDialogListener");
        }
    }

}
