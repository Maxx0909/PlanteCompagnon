package pack.plantecompagnon.src.service;

import android.os.Handler;
import android.os.Looper;

import androidx.core.util.Consumer;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pack.plantecompagnon.src.DAO.UserPlantDao;
import pack.plantecompagnon.src.model.HousePieceList;
import pack.plantecompagnon.src.model.PlantOriginList;
import pack.plantecompagnon.src.model.PlantStatusList;
import pack.plantecompagnon.src.model.UserPlant;

public class UserPlantService {
    private final UserPlantDao userPlantDao;

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public UserPlantService(UserPlantDao userPlantDao){
        this.userPlantDao = userPlantDao;
    }


    public void addNewUserPlant(String name, int age, PlantStatusList status, int size, boolean favorite, HousePieceList location, Date arrivalDate, PlantOriginList origin, String picture, String notes, String userId){
        executorService.execute(() ->{

            //convertir status
            String newStatus = status.toString().toLowerCase();

            //convertir location
            String newLocation = location.toString().toLowerCase();

            //convertir origin
            String newOrigin = origin.toString().toLowerCase();

            UserPlant userPlant = new UserPlant(name, age, newStatus, size, favorite, newLocation, arrivalDate.toString(), newOrigin, picture, notes, userId);

            userPlantDao.insert(userPlant);
        });
    }

    public void deleteUserPlant(UserPlant userPlant) {
        executorService.execute(() -> userPlantDao.delete(userPlant));
    }

    public void modifyUserPlant(UserPlant userPlant, String name, int age, PlantOriginList status, int size, boolean favorite, HousePieceList location, Date arrivalDate, PlantOriginList origin, String picture, String notes) {
        executorService.execute(() -> {
            userPlant.setName(name);
            userPlant.setAge(age);
            userPlant.setStatus(status.toString().toLowerCase());
            userPlant.setSize(size);
            userPlant.setFavorite(favorite);
            userPlant.setLocation(location.toString().toLowerCase());
            userPlant.setArrivalDate(arrivalDate.toString());
            userPlant.setOrigin(origin.toString().toLowerCase());
            userPlant.setPicture(picture);
            userPlant.setNotes(notes);

            userPlantDao.update(userPlant);
        });
    }

    public void addUserPlantToFavorite(UserPlant userPlant) {
        executorService.execute(() -> {
            userPlant.setFavorite(true);
            userPlantDao.update(userPlant);
        });
    }

    public void removeUserPlantFromFavorite(UserPlant userPlant) {
        executorService.execute(() -> {
            userPlant.setFavorite(false);
            userPlantDao.update(userPlant);
        });
    }


    public List<UserPlant> findUserPlant(String search) {
        return null;
    }

    public List<UserPlant> getAllFavorite() {
        return null;
    }

    public void getPlantById(int id, Consumer<UserPlant> callback){
        executorService.execute(() -> {
            UserPlant userPlant = userPlantDao.findById(id);
            new Handler(Looper.getMainLooper()).post(() -> callback.accept(userPlant));
        });
    }

    /*
    public List<Reminders> getAllPlantReminders() {
        return null;
    }

    public List<PlantProblems> getAllPlantProblems() {
        return null;
    }

     */

    public void shutdownExecutor() {
        executorService.shutdown();
    }
}
