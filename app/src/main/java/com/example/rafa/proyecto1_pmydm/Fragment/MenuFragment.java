package com.example.rafa.proyecto1_pmydm.Fragment;

/**
 * Created by rafa on 5/1/18.
 */

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafa.proyecto1_pmydm.Adapter.MenuAdapter;
import com.example.rafa.proyecto1_pmydm.Modelo.DatosMenu;
import com.example.rafa.proyecto1_pmydm.R;

import java.util.ArrayList;


public class MenuFragment extends Fragment {

    private ArrayList<DatosMenu> listadoOpcionesDelMenu;  //MANEL: Objecte on posarem les opcions del menu
    private RecyclerView recyclerView;

    //MANEL, Per a que el Fragment puga rebre paràmetres quan el creem, necessitem crear un constructor.
    // Seguint les directrius de Google,:
    //          https://developer.android.com/guide/components/fragments.html
    //          i este altre article http://gpmess.com/blog/2014/04/16/buenas-practicas-usando-fragments-en-android/
    //Necessitem crear un constructor i afegir els paràmetres del Fragment mitjançant el mètode setArguments

    public MenuFragment(){}

    public static MenuFragment newInstance(ArrayList<DatosMenu> opcionsDeMenuPerAlFragment){
        MenuFragment mf = new MenuFragment();
        if(opcionsDeMenuPerAlFragment!=null){
            Bundle b = new Bundle();
            b.putParcelableArrayList("key_llistaOpcionsMenuFragment",opcionsDeMenuPerAlFragment);
            mf.setArguments(b);
        }
        return mf;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listadoOpcionesDelMenu = getArguments().getParcelableArrayList("key_llistaOpcionsMenuFragment");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Añadimos el fragment a inflar desde el layout fragment_menu
        View view = inflater.inflate(R.layout.fragment_menu,container,false);

        //Añadimos el RecyclerView desde fragment_menu.xml

// RecyclerView recyclerView = view.findViewById(R.id.recyclerMenuID);
        // MANEL comente esta línia ja que al crear l'objecte recyclerView dins del mètode onCreateView()
        // ja que seria una variable local a este mètode, i no podriem utilitzar-la des d'altres mètodes.
        // La declare com un atribut de la classe MenuFragment

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerMenuID);
        recyclerView.setHasFixedSize(true); //Fijamos el tamaño en el layout del RecyclerView
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL)); //Lineas Divisorias en el Layout
        //Definimos el layout nuevo a adaptar
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //Añadimos el Adaptador creado en la clase MenuAdapter
        MenuAdapter menuAdapter = new MenuAdapter(listadoOpcionesDelMenu);
        recyclerView.setAdapter(menuAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
