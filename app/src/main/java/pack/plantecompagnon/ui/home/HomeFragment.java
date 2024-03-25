package pack.plantecompagnon.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pack.plantecompagnon.MainActivity;
import pack.plantecompagnon.R;
import pack.plantecompagnon.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private TextView welcomeText;

    private String pseudo = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        welcomeText = root.findViewById(R.id.welcomeText);


        //récupérer le pseudo de l'activité
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            pseudo = activity.pseudo;
        }

        welcomeText.setText(welcomeText.getText() + pseudo);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}