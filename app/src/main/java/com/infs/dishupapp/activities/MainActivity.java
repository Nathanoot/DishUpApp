package com.infs.dishupapp.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.infs.dishupapp.R;
import com.infs.dishupapp.fragments.AvatarFragment;
import com.infs.dishupapp.fragments.CategoryFragment;

public class MainActivity extends AppCompatActivity implements  {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragment = new AvatarFragment();
        swapFragment(fragment);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.nav_avatar) {
                    Fragment fragment = new AvatarFragment();
                    swapFragment(fragment);
                    setFragmentTitle("Cat breeds");
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_recipes) {
                    Fragment fragment = new CategoryFragment();
                    swapFragment(fragment);
                    setFragmentTitle("Favourites");
                    return true;
                }
                return false;
            }
        });
    }

    public void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void setFragmentTitle(String title) {
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(title);
    }

}

