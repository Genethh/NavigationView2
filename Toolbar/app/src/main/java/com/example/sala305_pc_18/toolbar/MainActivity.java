package com.example.sala305_pc_18.toolbar;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragmentUno.OnFragmentInteractionListener,BlankFragmentDos.OnFragmentInteractionListener,BlankFragmentTres.OnFragmentInteractionListener{

    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu_dos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navView = (NavigationView)findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        boolean fragmentTransaction = false;
                        Fragment fragment = null;
                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                fragment = new BlankFragmentUno();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_2:
                                fragment = new BlankFragmentDos();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_3:
                                fragment = new BlankFragmentTres();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_opcion_1:
                                Toast.makeText(getApplicationContext(),"Click en OPCION UNO ",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_opcion_2:
                                Toast.makeText(getApplicationContext(),"Click en OPCION DOS ",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();
                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_uno , menu);
        return true; }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Nuevo:
                Toast.makeText(getApplicationContext(),"Click en NUEVO",Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,"Click en NUEVO",0).show();
                return true;

            case R.id.Buscar:
                Toast.makeText(getApplicationContext(),"Click en BUSCAR",Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,"Click en BUSCAR",1).show();
                return true;

            case R.id.Configuraciones:
                Toast.makeText(getApplicationContext(),"Click en Configuracion",Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,"Click en CONFIGURACIONES",1).show(); //EL VALOR DE DURACION ESTA DADO EN SEGUNDOS
                return true;

            case android.R.id.home:
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                 return super.onOptionsItemSelected(item);
        }
    }

    public void onClickFAB(View view) {
        Snackbar.make(view, "Se presionó el FloatingActionButton - FAB", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }



/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*/
        @Override
        public void onFragmentInteraction(Uri uri){
            //you can leave it empty
        }



}
