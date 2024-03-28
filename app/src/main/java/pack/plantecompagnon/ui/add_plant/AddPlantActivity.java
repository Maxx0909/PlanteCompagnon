package pack.plantecompagnon.ui.add_plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.R;
import pack.plantecompagnon.src.DAO.UserPlantDao;
import pack.plantecompagnon.src.model.HousePieceList;
import pack.plantecompagnon.src.model.PlantOriginList;
import pack.plantecompagnon.src.model.PlantStatusList;
import pack.plantecompagnon.src.service.UserPlantService;

public class AddPlantActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText sizeEditText;
    private DatePicker arrivalDatePicker;
    private Spinner statusSpinner;
    private Spinner locationSpinner;
    private Spinner originSpinner;
    private EditText notesEditText;
    private CheckBox favoriteCheckBox;

    private ArrayAdapter<PlantStatusList> adapterStatus;
    private ArrayList<PlantStatusList> plantStatusList = new ArrayList<PlantStatusList>(PlantStatusList.getPlantStatusList());

    private ArrayAdapter<HousePieceList> adapterHousePiece;
    private ArrayList<HousePieceList> housePieceList = new ArrayList<HousePieceList>(HousePieceList.getHousePieceList());

    private ArrayAdapter<PlantOriginList> adapterOrigin;
    private ArrayList<PlantOriginList> plantOriginList = new ArrayList<PlantOriginList>(PlantOriginList.getPlantOriginList());

    private String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        if(intent != null){
            pseudo = intent.getStringExtra("pseudo");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);


        nameEditText = findViewById(R.id.plantName);
        ageEditText = findViewById(R.id.plantAge);
        sizeEditText = findViewById(R.id.plantSize);
        arrivalDatePicker = findViewById(R.id.plantDateArrival);
        statusSpinner = findViewById(R.id.plantStatus);
        locationSpinner = findViewById(R.id.plantLocalization);
        originSpinner = findViewById(R.id.plantOrigin);
        notesEditText = findViewById(R.id.plantNotes);
        favoriteCheckBox = findViewById(R.id.plantFavorite);


        //adpater les spinner avec les valeurs de l'énumération
        adapterOrigin = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, plantOriginList);
        originSpinner.setAdapter(adapterOrigin);

        adapterStatus = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, plantStatusList);
        statusSpinner.setAdapter(adapterStatus);


        adapterHousePiece = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, housePieceList);
        locationSpinner.setAdapter(adapterHousePiece);

    }

    public void onAddPlantButtonClick(View view){

        //vérification que tous les champs obligatoires soient rempli
        if(nameEditText.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(this,
                    "Merci de remplir les champs obligatoire pour ajouter une nouvelle plante",
                    Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        UserPlantDao userPlantDao = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().userPlantDao();
        UserPlantService userPlantService = new UserPlantService(userPlantDao);

        HousePieceList location = (HousePieceList) locationSpinner.getSelectedItem();
        PlantOriginList origin = (PlantOriginList) originSpinner.getSelectedItem();
        PlantStatusList status = (PlantStatusList) statusSpinner.getSelectedItem();


        //traitement date arrivée
        Calendar calendarArrivalDate = Calendar.getInstance();
        calendarArrivalDate.clear();

        calendarArrivalDate.set(Calendar.YEAR, arrivalDatePicker.getYear());
        calendarArrivalDate.set(Calendar.MONTH, arrivalDatePicker.getMonth());
        calendarArrivalDate.set(Calendar.DAY_OF_MONTH, arrivalDatePicker.getDayOfMonth());

        long timeInMillis = calendarArrivalDate.getTimeInMillis();
        Date dateArrivalDate = new Date(timeInMillis);

        int age = 0;
        if(!ageEditText.getText().toString().isEmpty()){
            age = Integer.parseInt(ageEditText.getText().toString());
        }

        int size = 0;
        if(!sizeEditText.getText().toString().isEmpty()){
            size = Integer.parseInt(sizeEditText.getText().toString());
        }


        userPlantService.addNewUserPlant(
                nameEditText.getText().toString(),
                age,
                status,
                size,
                favoriteCheckBox.isActivated(), //ok ici ???
                location,
                dateArrivalDate,
                origin,
                null,
                notesEditText.getText().toString(),
                pseudo
        );

        // TODO: 28/03/2024 A vérifier que l'exécution se fait bien avant d'arreter le service...
        userPlantService.shutdownExecutor();

        Toast toast = Toast.makeText(this,
                "Votre nouvelle plante "+ nameEditText.getText().toString() + " a bien été ajoutée !",
                Toast.LENGTH_SHORT);
        toast.show();

        //dépiler activité
        finish();
    }
}
