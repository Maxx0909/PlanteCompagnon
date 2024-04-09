package pack.plantecompagnon.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;

import java.util.List;

import pack.plantecompagnon.BD.DatabaseClient;
import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;
import pack.plantecompagnon.src.DAO.UserPlantDao;
import pack.plantecompagnon.src.model.UserPlant;
import pack.plantecompagnon.src.service.UserPlantService;
import pack.plantecompagnon.ui.information_user_plant.InformationUserPlantActivity;

public class HomeFragment extends Fragment {

    private TextView welcomeText;
    private String pseudo = "";
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);

        welcomeText = root.findViewById(R.id.welcomeText);


        //récupérer le pseudo de l'activité
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            pseudo = activity.pseudo;
        }

        welcomeText.setText(welcomeText.getText() + pseudo);

        createFrameLayout(root, root.getContext());

        return root;
    }

    public void createFrameLayout(View root, Context context){
        GridLayout gridLayout = root.findViewById(R.id.homeGridLayout);

        UserPlantDao userPlantDao = DatabaseClient.getInstance(getContext()).getAppDatabase().userPlantDao();
        UserPlantService userPlantService = new UserPlantService(userPlantDao);

        Consumer<List<UserPlant>> callback = userPlantList -> {
            getActivity().runOnUiThread(() -> {

                for(int i =0; i<userPlantList.size(); i++){
                    FrameLayout frameLayout = new FrameLayout(context);

                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            350,
                            350,
                            Gravity.CENTER
                    );

                    layoutParams.setMargins(65, 10, 50, 10);
                    frameLayout.setLayoutParams(layoutParams);

                    frameLayout.setClickable(true);
                    frameLayout.setFocusable(true);

                    //définir un listener pour le bouton
                    int finalI = i;
                    frameLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onContainerClick(v, userPlantList.get(finalI).getId());
                        }
                    });

                    //création de l'imageView
                    ImageView imageView = createImageView(context, null);
                    frameLayout.addView(imageView);

                    //création du textView
                    // TODO: 09/04/2024 changer name ici
                    TextView textView = createTextView(context, userPlantList.get(i).getName());
                    frameLayout.addView(textView);

                    //ajouter la frameLayout à la vue
                    gridLayout.addView(frameLayout);
                }
            });
        };

        userPlantService.getAllUserPlant(pseudo, callback);

        userPlantService.shutdownExecutor();

    }

    private ImageView createImageView(Context context, String pictureName){
        ImageView imageView = new ImageView(context);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, // Largeur
                FrameLayout.LayoutParams.MATCH_PARENT); // Hauteur
        imageView.setLayoutParams(layoutParams);

        // TODO: 08/04/2024 A changer ici pour les images 
        imageView.setImageResource(R.drawable.ic_launcher_foreground);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return imageView;
    }

    private TextView createTextView(Context context, String name){
        
        TextView textView = new TextView(context);


        textView.setText(name);

        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);

        textView.setBackgroundColor(Color.parseColor("#AA000000"));

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL
        );

        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void onContainerClick(View v, int id){
        Intent intent = new Intent(this.getActivity(), InformationUserPlantActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

        //actualisation des données après insertion d'une nouvelle plante
        onResume();
    }

    @Override
    public void onResume() {
        super.onResume();

        refreshData();
    }

    private void refreshData() {
        GridLayout gridLayout = root.findViewById(R.id.homeGridLayout);
        gridLayout.removeAllViews();

        createFrameLayout(root, root.getContext());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

}