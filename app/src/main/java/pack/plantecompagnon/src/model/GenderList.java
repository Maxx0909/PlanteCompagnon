package pack.plantecompagnon.src.model;

import java.util.ArrayList;

public enum GenderList {
    FEMININ,
    MASCULIN,
    AUTRE;

    //méthode pour renvoyer les valeurs de l'énumération
    public static ArrayList<GenderList> getGenderList(){
        ArrayList<GenderList> genderList = new ArrayList<GenderList>();

        for (int i=0; i<values().length; i++){
            genderList.add(GenderList.valueOf(values()[i].name()));
        }

        return genderList;
    }
}



