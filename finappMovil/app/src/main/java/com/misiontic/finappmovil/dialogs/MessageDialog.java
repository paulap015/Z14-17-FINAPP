package com.misiontic.finappmovil.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MessageDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle estado){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(getActivity());
        mensaje.setTitle("Confirmación");
        mensaje.setMessage("La accion que realizara eliminara tal cosa. 'Esta seguro de hacer esta acción? ");
        mensaje.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Se ha eliminado el registro",Toast.LENGTH_SHORT);
            }
        });
        mensaje.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return mensaje.create();
    }
}
