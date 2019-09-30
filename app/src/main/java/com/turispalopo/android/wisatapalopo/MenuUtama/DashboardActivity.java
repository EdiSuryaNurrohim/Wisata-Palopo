package com.turispalopo.android.wisatapalopo.MenuUtama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.turispalopo.android.wisatapalopo.MenuUtama.menufragment.DaruratFragment;
import com.turispalopo.android.wisatapalopo.MenuUtama.menufragment.HomeFragment;
import com.turispalopo.android.wisatapalopo.MenuUtama.menufragment.InfoFragment;
import com.turispalopo.android.wisatapalopo.MenuUtama.menufragment.PetaFragment;
import com.turispalopo.android.wisatapalopo.MenuUtama.menufragment.ProfileFragment;
import com.turispalopo.android.wisatapalopo.R;

public class DashboardActivity extends AppCompatActivity {

    //firebaseauth
    FirebaseAuth firebaseAuth;

    ActionBar actionBar;

    //tampilan
    TextView mProfileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Actionbar dan title
        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        //init
        firebaseAuth = FirebaseAuth.getInstance();

        //bottom Navigation
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //handle item click
            switch (menuItem.getItemId()){
                case  R.id.nav_home:
                    actionBar.setTitle("Home Wisata");
                    //home fragment transaction
                    HomeFragment fragment1 = new HomeFragment();
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.content, fragment1, "");
                    ft1.commit();
                    return true;
                case  R.id.nav_peta:
                    actionBar.setTitle("Peta Wisata");
                    PetaFragment fragment2 = new PetaFragment();
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.content, fragment2, "");
                    ft2.commit();
                    return true;
                case  R.id.nav_darurat:
                    actionBar.setTitle("Telpon Darurat");
                    DaruratFragment fragment3 = new DaruratFragment();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.content, fragment3, "");
                    ft3.commit();
                    return true;
                //case  R.id.nav_profile:
                //    actionBar.setTitle("Profile");
                //    ProfileFragment fragment4 = new ProfileFragment();
                //    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                //   ft4.replace(R.id.content, fragment4, "");
                //    ft4.commit();
                //    return true;
                case  R.id.nav_info:
                    actionBar.setTitle("Info Aplikasi");
                    InfoFragment fragment5 = new InfoFragment();
                    FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
                    ft5.replace(R.id.content, fragment5, "");
                    ft5.commit();
                    return true;


            }

            return false;
        }
    };

    private void  checkUserStatus(){
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user !=null){
            //user is sign in

            //set email looged
            //mProfileTv.setText(user.getEmail());

        }
        else{
            //user not signed in
            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    protected void onStart(){
        //check onstar app
        checkUserStatus();
        super.onStart();
    }

    //inflate options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflating menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //handle menu item click


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //get item id
      int id = item.getItemId();
      if (id == R.id.action_logout){
          firebaseAuth.signOut();
          checkUserStatus();

      }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity
        return super.onSupportNavigateUp();
    }
}
