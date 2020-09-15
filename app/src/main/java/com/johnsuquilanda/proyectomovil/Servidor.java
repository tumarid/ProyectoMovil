package com.johnsuquilanda.proyectomovil;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Servidor extends SQLiteOpenHelper {
    private static final String  DATABASE="uniformes.db";
    Context miContext;

    public Servidor(@Nullable Context context){
        super (context, DATABASE, null, 1);
        miContext=context;
        File miArchivo=miContext.getDatabasePath(DATABASE);

        if (!verificarBD(miArchivo.getAbsolutePath())){
            try {
                copiarBD(miArchivo);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private  boolean verificarBD (String ruta){
        SQLiteDatabase miBase=null;

        try{
            miBase= SQLiteDatabase.openDatabase(ruta,null,SQLiteDatabase.OPEN_READONLY);
        }catch (Exception e){
            e.printStackTrace();
        }


        if (miBase!=null){
            miBase.close();
        }
        return miBase!=null;
    }
    private void copiarBD(File archivoBD) throws IOException {
        InputStream inputStream=miContext.getAssets().open(DATABASE);
        OutputStream outputStream=new FileOutputStream(archivoBD);
        byte[]buffer=new byte[1024];
        int largo;
        while ((largo=inputStream.read(buffer))>0){
            outputStream.write(buffer,0,largo);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public String ingresoCliente(usuario usuarios){
        String sql="INSERT INTO cliente(identificacion,nombre,direccion,telefono,correo)";
        sql+="VALUES('"+usuarios.getUsuario()+"','"+usuarios.getContraseña()+"','"+usuarios.getNombre()+"','"+usuarios.getApellido()+"','"+usuarios.getTelefono()+"','"+usuarios.getCorreo()+"','"+usuarios.getDireccion()+"')";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error en la creacion del USUARIO"+ ex.getMessage();
        }
        return null;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
