package pack.plantecompagnon.BD;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //tous les DAOs de mon app ici
    public abstract UserDao userDao();

}
