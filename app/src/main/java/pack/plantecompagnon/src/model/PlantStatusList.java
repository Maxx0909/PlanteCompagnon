package pack.plantecompagnon.src.model;

import java.util.ArrayList;

public enum PlantStatusList {
    BONNE_SANTE,
    CROISSANCE,
    FLORAISON,
    HIBERNATION,
    MALADE,
    MORTE;

    //méthode pour renvoyer les valeurs de l'énumération
    public static ArrayList<PlantStatusList> getPlantStatusList(){
        ArrayList<PlantStatusList> plantStatusList = new ArrayList<PlantStatusList>();

        for (int i=0; i<values().length; i++){
            plantStatusList.add(PlantStatusList.valueOf(values()[i].name()));
        }

        return plantStatusList;
    }
}
