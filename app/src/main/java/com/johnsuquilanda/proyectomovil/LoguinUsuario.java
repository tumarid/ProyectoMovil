package com.johnsuquilanda.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoguinUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Servidor usuario=new Servidor(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin_usuario);
        //casting componentes
        Button buttonGrabar=(Button)findViewById(R.id.btnRegistrarse);
        Bundle datos = getIntent().getExtras();
        final TextView titulo = (TextView)findViewById(R.id.textView);
        final EditText editTextUsuario=(EditText)findViewById(R.id.textUsuario);
        final EditText editTextContraseña=(EditText)findViewById(R.id.textContraseña);
        final EditText editTextNombre=(EditText)findViewById(R.id.textNombre);
        final EditText editTextApellido=(EditText)findViewById(R.id.textApellido);
        final EditText editTextTelefono=(EditText)findViewById(R.id.textTelefono);
        final  EditText editTextCorreo=(EditText)findViewById(R.id.textCorreo);
        final  EditText editTextDireccion=(EditText)findViewById(R.id.textDireccion);
        if(datos==null){
            titulo.setText("Nuevo cliente");
            buttonGrabar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(editTextUsuario.getText().toString().isEmpty()){
                        editTextUsuario.setError("Ingrese usuario");
                        editTextUsuario.requestFocus();
                        return;
                    }
                    if(editTextContraseña.getText().toString().isEmpty()){
                        editTextContraseña.setError("Ingrese contraseña");
                        editTextContraseña.requestFocus();
                        return;
                    }
                    if(editTextNombre.getText().toString().isEmpty()){
                        editTextNombre.setError("Ingrese el nombre");
                        editTextNombre.requestFocus();
                        return;
                    }
                    if(editTextApellido.getText().toString().isEmpty()){
                        editTextApellido.setError("Ingrese el nombre");
                        editTextApellido.requestFocus();
                        return;
                    }
                    if(editTextTelefono.getText().toString().isEmpty()){
                        editTextTelefono.setError("Ingrese el telefono");
                        editTextTelefono.requestFocus();
                        return;
                    }
                    if(editTextCorreo.getText().toString().isEmpty()){
                        editTextCorreo.setError("Ingrese el correo");
                        editTextCorreo.requestFocus();
                        return;
                    }
                    if(editTextDireccion.getText().toString().isEmpty()){
                        editTextDireccion.setError("Ingrese la direccion");
                        editTextDireccion.requestFocus();
                        return;
                    }


                    usuario c = new usuario(editTextUsuario.getText().toString(),editTextContraseña.getText().toString(), editTextNombre.getText().toString(),editTextApellido.getText().toString(), editTextTelefono.getText().toString(), editTextCorreo.getText().toString(), editTextDireccion.getText().toString());
                    if (usuario.ingresoCliente(c) == null) {
                        Toast.makeText(getApplicationContext(), "Guardado Correctamente", Toast.LENGTH_SHORT);
                        finish();
                        return;
                    } else {
                        Toast.makeText(getApplicationContext(), usuario.ingresoCliente(c), Toast.LENGTH_SHORT);
                    }


                }
            });


        }





    }
}