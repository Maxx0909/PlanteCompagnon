package pack.plantecompagnon.src.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

import pack.plantecompagnon.src.model.UserPlant;

@Dao
public interface UserPlantDao {

    @Insert
    void insert(UserPlant userPlant);

    @Update
    void update(UserPlant userPlant);

    @Delete
    void delete(UserPlant userPlant);

    //récupére les informations de la plante d'id id
    @Query("SELECT * FROM USERPLANT WHERE id = :id")
    UserPlant findById(int id);


    //récupérer la liste de toute les plantes de l'utilisateur
    @Query("SELECT * FROM UserPlant  WHERE userId = :pseudo ")
    List<UserPlant> getAllUserPlant(String pseudo);

}
