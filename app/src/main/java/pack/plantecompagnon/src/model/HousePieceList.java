package pack.plantecompagnon.src.model;

import java.util.ArrayList;

public enum HousePieceList {
    BALCON,
    BUREAU,
    CHAMBRE,
    CUISINE,
    JARDIN,
    MEZZANINE,
    SALLE_A_MANGER,
    SALLE_DE_BAIN,
    SALON,
    TERRASSE,
    VERANDA,
    WC,
    AUTRE;

    //méthode pour renvoyer les valeurs de l'énumération
    public static ArrayList<HousePieceList> getHousePieceList(){
        ArrayList<HousePieceList> housePieceList = new ArrayList<HousePieceList>();

        for (int i=0; i<values().length; i++){
            housePieceList.add(HousePieceList.valueOf(values()[i].name()));
        }

        return housePieceList;
    }


}
