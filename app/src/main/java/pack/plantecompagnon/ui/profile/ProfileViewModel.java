package pack.plantecompagnon.ui.profile;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pack.plantecompagnon.R;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> pseudo = new MutableLiveData<>();
    private MutableLiveData<Integer> nbPlants = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> birthDate = new MutableLiveData<>();
    private MutableLiveData<String> gender = new MutableLiveData<>();
    private MutableLiveData<String> city = new MutableLiveData<>();


    public ProfileViewModel() {


    }

    public LiveData<String> getPseudo() {
        return pseudo;
    }
    public LiveData<Integer> getNbPlants() {
        return nbPlants;
    }
    public LiveData<String> getEmail() {
        return email;
    }
    public LiveData<String> getBirthDate() {
        return birthDate;
    }
    public LiveData<String> getGender() {
        return gender;
    }
    public LiveData<String> getCity() {
        return city;
    }

    public void setPseudo(String value) {
        pseudo.setValue(value);
    }
    public void setNbPlants(int value) {
        nbPlants.setValue(value);
    }
    public void setEmail(String value) {
        email.setValue(value);
    }
    public void setBirthDate(String value) {
        birthDate.setValue(value);
    }
    public void setGender(String value) {
        gender.setValue(value);
    }
    public void setCity(String value) {
        city.setValue(value);
    }

}