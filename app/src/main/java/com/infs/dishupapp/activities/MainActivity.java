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
import com.infs.dishupapp.fragments.NotesFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      On start up of the app, create Avatar fragment and swap it in
        Fragment fragment = new AvatarFragment();
        swapFragment(fragment);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.nav_avatar) {
                    Fragment fragment = new AvatarFragment();
                    // Swap avatar fragment in on clicking first navigation button
                    swapFragment(fragment);
                    setFragmentTitle("Profile");
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_recipes) {
                    Fragment fragment = new CategoryFragment();
                    // Swap category fragment in on clicking second navigation button
                    swapFragment(fragment);
                    setFragmentTitle("Recipes");
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_notes) {
                    Fragment fragment = new NotesFragment();
                    // Swap notes fragment in on clicking third navigation button
                    swapFragment(fragment);
                    setFragmentTitle("Notes");
                }
                return false;
            }
        });
    }
// Method for swapping fragments
    public void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
// Method for setting the title of each fragment
    private void setFragmentTitle(String title) {
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(title);
    }

}

