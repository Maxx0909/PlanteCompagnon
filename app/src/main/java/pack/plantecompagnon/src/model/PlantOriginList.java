package pack.plantecompagnon.src.model;

import java.util.ArrayList;

public enum PlantOriginList {
    ACHAT,
    BOUTURE,
    CADEAU,
    AUTRE;

    //méthode pour renvoyer les valeurs de l'énumération
    public static ArrayList<PlantOriginList> getPlantOriginList(){
        ArrayList<PlantOriginList> plantOriginList = new ArrayList<PlantOriginList>();

        for (int i=0; i<values().length; i++){
            plantOriginList.add(PlantOriginList.valueOf(values()[i].name()));
        }

        return plantOriginList;
    }
}