package pack.plantecompagnon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pack.plantecompagnon.databinding.ActivityConnexionBinding;
import pack.plantecompagnon.databinding.ActivityMainBinding;
import pack.plantecompagnon.ui.add_plant.AddPlantActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        if(intent != null){
            pseudo = intent.getStringExtra("pseudo");
        }

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ActivityConnexionBinding.inflate(getLayoutInflater());


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_profile, R.id.navigation_home, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

    public void onAddPlantButtonClick(View view) {
        //changement de vue
        Intent intent = new Intent(this, AddPlantActivity.class);
        intent.putExtra("pseudo", pseudo);
        startActivity(intent);
    }
}