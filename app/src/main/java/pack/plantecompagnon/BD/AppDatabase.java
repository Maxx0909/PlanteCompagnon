package pack.plantecompagnon.BD;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.DAO.UserPlantDao;
import pack.plantecompagnon.src.model.User;
import pack.plantecompagnon.src.model.UserPlant;

@Database(entities = {User.class, UserPlant.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    //tous les DAOs de mon app ici
    public abstract UserDao userDao();
    public abstract UserPlantDao userPlantDao();


}
