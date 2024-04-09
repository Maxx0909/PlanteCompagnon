package pack.plantecompagnon.src.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pack.plantecompagnon.src.model.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User userPlant);

    @Update
    void update(User userPlant);

    @Delete
    void delete(User userPlant);


    //récupére le nombre de plantes pour un utilisateur
    @Query("SELECT count(*) FROM UserPlant WHERE userId = :pseudo")
    int getCountUserPlant(String pseudo);


    //récupére 1 User en fonction de son pseudo
    @Query("SELECT * FROM User WHERE pseudo = :pseudo")
    User findByPseudo(String pseudo);
}
