package com.example.rafa.proyecto1_pmydm;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rafa.proyecto1_pmydm.Fragment.MenuFragment;
import com.example.rafa.proyecto1_pmydm.Modelo.DatosMenu;

import java.util.ArrayList;
/**
 * Created by rafa on 5/1/18.
 */

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_menu);
        ArrayList<DatosMenu> opcionsDelMenu=new ArrayList<>();
        opcionsDelMenu.add(new DatosMenu("PERFIL",R.drawable.face));
        opcionsDelMenu.add(new DatosMenu("JUEGO",R.drawable.ps4));
        opcionsDelMenu.add(new DatosMenu("INSTRUCCIONES",R.drawable.cup));
        opcionsDelMenu.add(new DatosMenu("INFORMACIÓN", R.drawable.sup));



        //6-Le pasamos el Fragment definido en la clase MenuFragment
        //MANEL Comente esta línia la que els paràmetres del FRagment els passem via el mètode
        // newInstance(paràmetres)
        // MenuFragment fragment = new MenuFragment();
        MenuFragment fragment = MenuFragment.newInstance(opcionsDelMenu);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Le pasamos el ID del Fragment del activity_menu.xml
        fragmentTransaction.add(R.id.frameMenu,fragment);
        fragmentTransaction.commit(); //Lanzamos el fragment en nuestra Activity Menu_Activity
    }
}
