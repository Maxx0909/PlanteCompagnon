package pack.plantecompagnon.src.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import pack.plantecompagnon.src.model.UserPlant;

@Dao
public interface UserPlantDao {

    @Insert
    void insert(UserPlant userPlant);

    @Update
    void update(UserPlant userPlant);

    @Delete
    void delete(UserPlant userPlant);

    @Query("SELECT * FROM USERPLANT WHERE id = :id")
    UserPlant findById(int id);



}
