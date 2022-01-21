package com.veercreation.vinsta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.veercreation.vinsta.databinding.ActivityMainBinding;
import com.veercreation.vinsta.fragments.AddFragment;
import com.veercreation.vinsta.fragments.HomeFragment;
import com.veercreation.vinsta.fragments.NotificationFragment;
import com.veercreation.vinsta.fragments.ProfileFragment;
import com.veercreation.vinsta.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        MainActivity.this.setTitle("My Profile");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        binding.toolbar.setVisibility(View.GONE);
        fragmentTransaction.replace(R.id.frameLayout_container, new ProfileFragment());
        fragmentTransaction.commit();

        binding.readableBottomBar.setOnItemSelectListener(i -> {
            switch (i) {
                case 0:
                    FragmentTransaction fragmentTransaction0 = getSupportFragmentManager().beginTransaction();
                    binding.toolbar.setVisibility(View.GONE);
                    fragmentTransaction0.replace(R.id.frameLayout_container, new HomeFragment());
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                    fragmentTransaction0.commit();
                    break;
                case 1:
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    binding.toolbar.setVisibility(View.GONE);
                    fragmentTransaction1.replace(R.id.frameLayout_container, new NotificationFragment());
                    Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                    fragmentTransaction1.commit();
                    break;
                case 2:
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    binding.toolbar.setVisibility(View.GONE);
                    fragmentTransaction2.replace(R.id.frameLayout_container, new AddFragment());
                    Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                    fragmentTransaction2.commit();
                    break;
                case 3:
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    binding.toolbar.setVisibility(View.GONE);
                    fragmentTransaction3.replace(R.id.frameLayout_container, new SearchFragment());
                    fragmentTransaction3.commit();
                    break;
                case 4:
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    binding.toolbar.setVisibility(View.VISIBLE);
                    fragmentTransaction4.replace(R.id.frameLayout_container, new ProfileFragment());
                    fragmentTransaction4.commit();
            break;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items , menu);
        return  true;
//        return super.onCreateOptionsMenu(menu);
    }
}