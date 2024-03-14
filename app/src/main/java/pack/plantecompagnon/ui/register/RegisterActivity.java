package pack.plantecompagnon.ui.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;

import java.util.Date;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;
import pack.plantecompagnon.src.model.GenderList;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.model.User;
import pack.plantecompagnon.src.service.UserService;
import pack.plantecompagnon.ui.home.HomeViewModel;
import pack.plantecompagnon.ui.register.*;

public class RegisterActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText email;
    private EditText password;
    private DatePicker birthDate;
    private Spinner gender;
    private EditText city;


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

    }

    //quand on clique sur le bouton s'inscrire
    public void onRegisterButtonClick(View view) {

        //vérification que tous les champs obligatoire soient rempli
        if(pseudo.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(this, "Merci de remplir les deux champs pour vous connecter", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        UserDao userDao = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        UserService userService = new UserService(userDao);

        //TO DO : à revoir et vérifier que ca fonctionne bien
        GenderList genderEnter = (GenderList) gender.getSelectedItem();
        Date dateEnter = new Date(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());

        userService.createAccount(pseudo.getText().toString(),
                email.getText().toString(),
                dateEnter,
                password.getText().toString(),
                genderEnter,
                city.getText().toString(),
                null);

        //détruire le service pour éviter les fuites mémoires
        userService.shutdownExecutor();

        //changement de vue
        //Intent intent = new Intent(this, .class);
        //startActivity(intent);
    }


}
