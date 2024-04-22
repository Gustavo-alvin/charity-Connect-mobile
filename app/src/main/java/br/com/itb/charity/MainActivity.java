package br.com.itb.charity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import br.com.itb.charity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.menu_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.menu_catalogo:
                    replaceFragment(new CatalogoFragment());
                    break;
                case R.id.menu_config:
                    replaceFragment(new ConfigFragment());
                    break;
            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
