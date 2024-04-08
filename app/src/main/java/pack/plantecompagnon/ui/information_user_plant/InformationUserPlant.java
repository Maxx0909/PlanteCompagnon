package pack.plantecompagnon.ui.information_user_plant;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.R;
import pack.plantecompagnon.src.DAO.UserPlantDao;
import pack.plantecompagnon.src.model.UserPlant;
import pack.plantecompagnon.src.service.UserPlantService;

public class InformationUserPlant extends AppCompatActivity {

    private TextView nameTextView;
    private TextView ageTextView;
    private TextView statusTextView;
    private TextView sizeTextView;
    private TextView localisationTextView;
    private TextView dateArrivalTextView;
    private TextView originTextView;
    private TextView notesTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user_plant);

        nameTextView = findViewById(R.id.namePagePlant);
        ageTextView = findViewById(R.id.agePagePlant);
        statusTextView = findViewById(R.id.statusPagePlant);
        sizeTextView = findViewById(R.id.sizePagePlant);
        localisationTextView = findViewById(R.id.localizationPagePlant);
        dateArrivalTextView = findViewById(R.id.dateArrivalPagePlant);
        originTextView = findViewById(R.id.originPagePlant);
        notesTextView = findViewById(R.id.notesPagePlant);

        // TODO: 04/04/2024 changer le numéro id pour le récupérer par la page qui appel this 
        int id = 1;
        initInformation(id);

    }

    private void initInformation(int id) {

        UserPlantDao userPlantDao = (UserPlantDao) DatabaseClient.getInstance(this).getAppDatabase().userDao();
        UserPlantService userPlantService = new UserPlantService(userPlantDao);

        Consumer<UserPlant> callback = userPlantDB -> {
            runOnUiThread(() -> {

                //actualiser la vue avec les informations de la plante

                nameTextView.setText( nameTextView.getText() + userPlantDB.getName());
                ageTextView.setText( ageTextView.getText() + Integer.toString(userPlantDB.getAge()));
                statusTextView.setText( statusTextView.getText() + userPlantDB.getStatus());
                sizeTextView.setText( sizeTextView.getText() + Integer.toString(userPlantDB.getSize()));
                localisationTextView.setText( localisationTextView.getText() + userPlantDB.getLocation());
                originTextView.setText( originTextView.getText() + userPlantDB.getOrigin());
                notesTextView.setText( notesTextView.getText() + userPlantDB.getNotes());

                String date[] = parseDate(userPlantDB.getArrivalDate());
                dateArrivalTextView.setText(dateArrivalTextView.getText() + date[0]+ " "+ date[1] + " "+ date[2]);
            });
        };


        userPlantService.getPlantById(id, callback);

    }

    private String[] parseDate(String stringToSplit){

        String[] stringSplit = stringToSplit.split(" ");

        String day = stringSplit[2];
        String month = stringSplit[1];
        String year = stringSplit[stringSplit.length -1];

        return new String[]{day, month, year};
    }


    // TODO: 04/04/2024 faire les 3 méthodes pour les boutons 
    public void onAddReminderButtonClick(){
        Toast toast = Toast.makeText(
                this, "En cour d'implémentation", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onAddCareButtonClick(){
        Toast toast = Toast.makeText(
                this, "En cour d'implémentation", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onAddProblemButtonClick(){
        Toast toast = Toast.makeText(
                this, "En cour d'implémentation", Toast.LENGTH_SHORT);
        toast.show();
    }

}
