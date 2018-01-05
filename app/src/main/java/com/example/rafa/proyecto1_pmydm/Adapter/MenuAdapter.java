package com.example.rafa.proyecto1_pmydm.Adapter;

/**
 * Created by rafa on 5/1/18.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafa.proyecto1_pmydm.InfoActivity;
import com.example.rafa.proyecto1_pmydm.InstruccionesActivity;
import com.example.rafa.proyecto1_pmydm.JuegoActivity;
import com.example.rafa.proyecto1_pmydm.Modelo.DatosMenu;
import com.example.rafa.proyecto1_pmydm.PerfilActivity;
import com.example.rafa.proyecto1_pmydm.R;

import java.util.ArrayList;


//5-Creamos el Adaptador del Menu y generamos e implementamos los métodos
public class MenuAdapter extends RecyclerView.Adapter{

    private ArrayList<DatosMenu> listadoOpcionesDelMenu;  //MANEL: Objecte on rebrem
    // les dades amb que treballarà l'adaptador.

    public MenuAdapter (ArrayList<DatosMenu> parametre){
        this.listadoOpcionesDelMenu=parametre;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflamos el list_menu.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return this.listadoOpcionesDelMenu.size();
    }

    //Definimos el Método ListViewHolder e implementamos el Listener
    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Definimos las variables a incluir ya creadas en el list_menu.xml
        private TextView mItemText;
        private ImageView mItemImage;

        //Declaramos el Constructor
        public ListViewHolder(View v){
            super(v);
            //Buscamos las variables por ID generadas list_menu.xml
            mItemText= (TextView) v.findViewById(R.id.textMenu);
            mItemImage= (ImageView) v.findViewById(R.id.imageMenu);
            v.setOnClickListener(this); //Inicializamos el Listener de cada elemento
        }

        //Creamos el Método bindView
        public void bindView(int position){
            //Le pasamos el texto y las imagenes creadas en la clase DatosMenu y lo obtenemos por posición
            mItemText.setText(listadoOpcionesDelMenu.get(position).getTitulo());
            mItemImage.setImageResource(listadoOpcionesDelMenu.get(position).getIconoMenu());
        }

        //Generamos el método onClick para los items del menu
        @Override
        public void onClick(View v) {
            int positon = getAdapterPosition();
            switch (positon){
                case 0:
                    Log.d("CLICK","Posición 1");
                    v.getContext().startActivity(new Intent(v.getContext(),PerfilActivity.class)); //Pasamos a la Activity PERFIL
                    // MANEL Si en el model haguerem definit també l'atribut activityACarregar, caldria fer la crida de la següent manera:
                    //  v.getContext().startActivity(new Intent(v.getContext(),listadoOpcionesDelMenu.get(position).getActivityACarregar()));
                    break;
                case 1:
                    Log.d("CLICK","Posición 2");
                    v.getContext().startActivity(new Intent(v.getContext(), JuegoActivity.class)); //Pasamos a la Activity JUEGO
                    break;
                case 2:
                    Log.d("CLICK","Posición 3");
                    v.getContext().startActivity(new Intent(v.getContext(), InstruccionesActivity.class)); //Pasamos a la Activity INSTRUCCIONES
                    break;
                case 3:
                    Log.d("CLICK","Posición 4");
                    v.getContext().startActivity(new Intent(v.getContext(), InfoActivity.class)); //Pasamos a la Activity INFORMACIÓN
                    break;
            }
        }
    }
}

