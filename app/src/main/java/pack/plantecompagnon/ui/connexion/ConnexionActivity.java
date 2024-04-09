package pack.plantecompagnon.ui.connexion;

import android.content.Intent;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.service.UserService;
import pack.plantecompagnon.ui.register.*;

public class ConnexionActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // récupérer le layout XML
        setContentView(R.layout.activity_connexion);

        // récup les composants
        pseudo = findViewById(R.id.pseudo);
        password = findViewById(R.id.password);
    }

    //quand on click sur le bouton Login
    public void onLoginButtonClick(View view) {

        if(pseudo.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(this, "Merci de remplir les deux champs pour vous connecter", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        UserDao userDao = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        UserService userService = new UserService(userDao);


        //récupére le résultat de la méthode connexion
        Consumer<Boolean> callback = success -> {
            runOnUiThread(() -> {
                if (success) {
                    // Connexion réussie, afficher un Toast et changer d'Activity
                    Toast.makeText(this, "Bienvenue sur Plante Compagnon", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("pseudo", pseudo.getText().toString());
                    startActivity(intent);
                } else {
                    // Échec de la connexion, afficher un message d'erreur
                    Toast.makeText(this, "Erreur lors de la connexion : veuillez vérifier les informations entrées", Toast.LENGTH_SHORT).show();
                }
            });
        };

        //demande de connexion
        userService.connexion(pseudo.getText().toString(), password.getText().toString(), callback);

        //détruire le service pour éviter les fuites mémoires
        userService.shutdownExecutor();
    }

    //quand on clique sur le bouton register
    public void onRegisterButtonClick(View view) {
        //changement de vue
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
