package com.example.app;


import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;

import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

    private String[] fragments;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private WebView webView;
    private boolean Cikis = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        webView = (WebView) findViewById(R.id.content_frame);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        //webView.scrollTo(0,0);
        webView.loadUrl("http://www.haberartibir.com.tr/m/");









        mTitle = "Gaste";

        fragments = new String[]{"Milliyet", "Radikal", "Hürriyet","Posta","HaberTürk","Sabah", "TRT Haber", "CNN Turk", "Ntvmsnbc", "T24", "F5 Haber", "OdaTv", "Dipnot", "Wall Street Türkiye", "RotaHaber", "GazetePort", "HaberVaktim"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, fragments));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {

                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                webView.scrollTo(0,0);//
                getActionBar().setTitle(mTitle);
            }
        };



        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



    
    
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:

                Intent intent1 = new Intent(getBaseContext(), MainActivity.class); //Refresh ile intent yeniden başlatılıyor...
                startActivity(intent1);
                return true;
            // action with ID action_settings was selected
            /*case R.id.action_settings:
                Intent intent = new Intent(getBaseContext(), Settings.class);//burada intent ile settngs classına yönlendiriyoruz...
                startActivity(intent);
                return true;*/
            default:
                break;

    }
    if (mDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);

}


    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentOne();

                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
            case 3:
                fragment = new FragmentPosta();
                break;
            case 4:
                fragment = new FragmentHaberTurk();
                break;
            case 5:
                fragment = new FragmentSabah();

                break;
            case 6:
                fragment = new FragmentTrt();
                break;
            case 7:
                fragment = new FragmentCnn();
                break;
            case 8:
                fragment = new FragmentNtv();
                break;
            case 9:
                fragment = new FragmentT24();
                break;

            case 10:
                fragment = new FragmentF5();
            break;
            case 11:
                fragment = new FragmentOdatv();
                break;
            case 12:
                fragment = new FragmentDipnot();
                break;
            case 13:
                fragment = new FragmentWsj();
                break;
            case 14:
                fragment = new FragmentRota();
                break;
            case 15:
                fragment = new FragmentGazetePort();
                break;
            case 16:
                fragment = new FragmentHaberVaktim();
                break;
            /*case 17:
                Intent intent1 = new Intent(MainActivity.this, intent.class);
                startActivity(intent1);*/



            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();   //WebView id'si burada !!!!!!!!

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            //setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }

    }



    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }



            private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);



        }

    }




   /* @Override
    public void onBackPressed() {//Geri tusuna basıldıgında..
        if( Cikis ) {



                mDrawerLayout.openDrawer(mDrawerList);
            } else {

                mDrawerLayout.closeDrawer(mDrawerList);


            }




    }*/

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {

            webView.goBack(); // go back in only the web view
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




    
    
}













