package pack.plantecompagnon.ui.profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;
import pack.plantecompagnon.databinding.FragmentProfileBinding;
import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.model.GenderList;
import pack.plantecompagnon.src.model.User;
import pack.plantecompagnon.src.service.UserService;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private TextView pseudoText;

    private TextView nbPlantText;
    private TextView emailText;


    private TextView birthDateText;
    private TextView genderText;
    private TextView cityText;

    private Button modifyButton;
    private Button deleteButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        pseudoText = root.findViewById(R.id.pseudoProfile);
        nbPlantText = root.findViewById(R.id.nbPlantesProfile);
        emailText = root.findViewById(R.id.emailProfile);
        birthDateText = root.findViewById(R.id.birthDateProfile);
        genderText = root.findViewById(R.id.genderProfile);
        cityText = root.findViewById(R.id.cityProfile);

        modifyButton = root.findViewById(R.id.buttonModify);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onModifyButtonClick(view);
            }
        });

        deleteButton = root.findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeletingButtonClick(view);
            }
        });


        initInformations();

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initInformations() {
        User user;

        UserDao userDao = DatabaseClient.getInstance(getContext()).getAppDatabase().userDao();
        UserService userService = new UserService(userDao);

        Consumer<User> callback = userDB -> {
            getActivity().runOnUiThread(() -> {

                //actualiser la vue avec les informations de l'utilisateur
                pseudoText.setText(userDB.getPseudo());

                // TODO: 25/03/2024 A changer le nombre de plantes

                if(userDB.getGender().toUpperCase().equals(GenderList.FEMININ.toString())){
                    nbPlantText.setText("Mère de " + 0 + " plantes");
                } else if (userDB.getGender().toUpperCase().equals(GenderList.MASCULIN.toString())){
                    nbPlantText.setText("Père de " + 0 + " plantes");
                } else {
                    nbPlantText.setText("Parent de " + 0 + " plantes");
                }
                emailText.setText(emailText.getText() + userDB.getEmail());
                String date[] = parseDate(userDB.getBirthDate());

                birthDateText.setText(birthDateText.getText() + date[0]+ " "+ date[1] + " "+ date[2]);
                genderText.setText(genderText.getText() + userDB.getGender());
                cityText.setText( cityText.getText() + userDB.getCity());
            });
        };

        // TODO: 25/03/2024 MODIFIER ICI POUR R2CUPERER LES INFOS DE L'UTILISATEUR CONNECTé 
        userService.getUser("Max", callback);

    }

    private String[] parseDate(String stringToSplit){

        String[] stringSplit = stringToSplit.split(" ");

        String day = stringSplit[2];
        String month = stringSplit[1];
        String year = stringSplit[stringSplit.length -1];

        return new String[]{day, month, year};
    }


    // TODO: 21/03/2024 : implémenter cette méthode (doit créer une page de modification....) 
    //quand on clique sur le bouton modifier le profile
    public void onModifyButtonClick(View view) {
        Toast toast = Toast.makeText(
                getContext(), "En cour d'implémentation", Toast.LENGTH_SHORT);
        toast.show();

    }

    // TODO: 21/03/2024 : à tester et trouver comment on fait pour revenir à la page de login... + faire une pop Up pour demander si on es sur de vouloir supprimer
    //quand on clique sur le bouton supprimer le compte
    public void onDeletingButtonClick(View view) {
        UserDao userDao = DatabaseClient.getInstance(getContext()).getAppDatabase().userDao();
        UserService userService = new UserService(userDao);

        //userService.deleteAccount(pseudo);
    }


}