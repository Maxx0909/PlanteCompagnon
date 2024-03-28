package pack.plantecompagnon.BD;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient instance;

    private AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        this.context = context;

        // TODO: 28/03/2024 .fallback à modifier lors de la mise en prod : actuellement les maj de la BD supprime toutes les données...
        //créer la BD
        appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "MyDatabase.db")
                .fallbackToDestructiveMigration()
                .build();
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
