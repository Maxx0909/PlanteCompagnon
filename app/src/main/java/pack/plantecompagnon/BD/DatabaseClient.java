package pack.plantecompagnon.BD;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient instance;

    private AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        this.context = context;

        //créer la BD
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyDatabase.db").build();
    }

    //format singleton
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    //retourner l'instance
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
