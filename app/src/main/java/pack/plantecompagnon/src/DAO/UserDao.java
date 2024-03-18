package pack.plantecompagnon.src.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pack.plantecompagnon.src.model.PlantWishlist;
import pack.plantecompagnon.src.model.User;
import pack.plantecompagnon.src.model.UserPlant;

@Dao
public interface UserDao {

    @Insert
    long insert(User userPlant);

    @Update
    void update(User userPlant);

    @Delete
    void delete(User userPlant);

/* A decommenter quand la classe Plante est faite
    //récupérer la liste de toute les plantes de l'utilisateur
    @Query("SELECT * FROM UserPlant  WHERE userId = :pseudo ")
    List<UserPlant> getAllUserPlant(String pseudo);

    //récupérer la whishList de l'utilisateur
    @Query("SELECT * FROM PlantWishlist WHERE userId = :pseudo")
    List<PlantWishlist> getWhishList(String pseudo);

    //récupére le nombre de plantes pour un utilisateur
    @Query("SELECT count(*) FROM UserPlant WHERE userId = :pseudo")
    int getCountUserPlant(String pseudo);

    */

    //récupére 1 User en fonction de son pseudo
    @Query("SELECT * FROM User WHERE pseudo = :pseudo")
    User findByPseudo(String pseudo);
}
