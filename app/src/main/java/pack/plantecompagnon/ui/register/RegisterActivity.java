package pack.plantecompagnon.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;
import pack.plantecompagnon.src.model.GenderList;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.service.UserService;

public class RegisterActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText email;
    private EditText password;
    private DatePicker birthDate;
    private Spinner gender;
    private EditText city;

    //attributs pour gérer la récupération de la GenderList et affichage dans le Spinner
    private ArrayAdapter<GenderList> adapter;
    private ArrayList<GenderList> genderList = new ArrayList<GenderList>(GenderList.getGenderList());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pseudo = findViewById(R.id.pseudo);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        birthDate = findViewById(R.id.birthDate);
        gender = findViewById(R.id.gender);
        city = findViewById(R.id.city);

        //adpater le spinner avec les valeurs de l'énumération GenderList
        adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, genderList);
        gender.setAdapter(adapter);
    }

    //quand on clique sur le bouton s'inscrire
    public void onRegisterButtonClick(View view) {

        //vérification que tous les champs obligatoire soient rempli
        if(pseudo.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(this,
                    "Merci de remplir les champs obligatoire pour vous inscrire",
                    Toast.LENGTH_SHORT);
            toast.show();
            return;
        }


        UserDao userDao = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        UserService userService = new UserService(userDao);

        GenderList genderEnter = (GenderList) gender.getSelectedItem();

        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        calendar.set(Calendar.YEAR, birthDate.getYear());
        calendar.set(Calendar.MONTH, birthDate.getMonth() - 1); //janvier = 0
        calendar.set(Calendar.DAY_OF_MONTH, birthDate.getDayOfMonth());

        long timeInMillis = calendar.getTimeInMillis();
        Date dateEnter = new Date(timeInMillis);

        //récupére le résultat de la méthode connexion
        Consumer<Boolean> callback = success -> {
            runOnUiThread(() -> {
                if (!success) {
                    //création du compte
                    userService.createAccount(
                            pseudo.getText().toString(),
                            email.getText().toString(),
                            dateEnter,
                            password.getText().toString(),
                            genderEnter,
                            city.getText().toString(),
                            null);

                    //détruire le service pour éviter les fuites mémoires
                    userService.shutdownExecutor();

                    //changement de vue
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("pseudo", pseudo.getText().toString());
                    startActivity(intent);
                } else {
                    // Échec de la connexion, afficher un message d'erreur
                    Toast.makeText(this, "Erreur un utilisateur a déjà ce pseudo : veuillez en choisir un autre", Toast.LENGTH_SHORT).show();

                    //détruire le service pour éviter les fuites mémoires
                    userService.shutdownExecutor();
                }
            });
        };

        //vérifier qu'un autre utilisateur n'a pas déjà le pseudo en question
        userService.findUserAlreadyRegister(pseudo.getText().toString(), callback);
    }
}
