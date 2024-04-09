package pack.plantecompagnon.src.service;

import android.os.Handler;
import android.os.Looper;

import androidx.core.util.Consumer;

import java.util.Date;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.model.GenderList;
import pack.plantecompagnon.src.model.User;

//librairie pour hasher le mot de passe
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private final UserDao userDao;

    private boolean result = false;

    //permet d'utiliser un thread pour l'exécution des opérations de BD de manière assynchrone
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void createAccount(String pseudo, String email, Date birthDate, String password, GenderList gender, String city, String picture){
       //exécution du thread
       executorService.execute(() ->{
            //hacher le password : utilisation de la fonction de hachage Bcrypt (rajoute du sel dans le hashage pour plus de sécurité)
            String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt()) ;

            //gender
            String newGender = gender.toString().toLowerCase();

            User user = new User(pseudo, email, birthDate.toString(), hashPassword, newGender, city, picture);

            userDao.insert(user);
       });
    }

    public void deleteAccount(User user){
        executorService.execute(() -> userDao.delete(user));
    }

    public void modifyInformation(User user, String pseudo, String email, Date birthDate, String password, GenderList gender, String city, String picture){
        executorService.execute(() -> {
            //user.setPseudo(pseudo);
            user.setEmail(email);
            user.setBirthDate(birthDate.toString());
            user.setGender(gender.toString().toLowerCase());
            user.setCity(city);
            user.setPicture(picture);

            if (password != null) {
                String newHash = BCrypt.hashpw(password, BCrypt.gensalt());
                user.setPassword(newHash);
            }

            userDao.update(user);
        });
    }

    public void getUser(String pseudo, Consumer<User> callback){
        executorService.execute(() -> {
            User user = userDao.findByPseudo(pseudo);
            new Handler(Looper.getMainLooper()).post(() -> callback.accept(user));
        });

    }

    public void getNumberUserPlant(String pseudo, Consumer<Integer> callback){
        executorService.execute(() -> {
            Integer nbPlant = userDao.getCountUserPlant(pseudo);
            new Handler(Looper.getMainLooper()).post(() -> callback.accept(nbPlant));
        });
    }

    public void connexion(String pseudo, String password, Consumer<Boolean> callback){
        executorService.execute(() -> {
            User user = userDao.findByPseudo(pseudo);
            result = false;
            if(user != null && BCrypt.checkpw(password, user.getPassword())){
                result = true;
            }
            new Handler(Looper.getMainLooper()).post(() -> callback.accept(result));
        });
    }

    public void findUserAlreadyRegister(String pseudo, Consumer<Boolean> callback){
        executorService.execute(() -> {
            User user = userDao.findByPseudo(pseudo);
            result = user != null;
            new Handler(Looper.getMainLooper()).post(() -> callback.accept(result));
        });
    }

    public void shutdownExecutor() {
        executorService.shutdown();
    }
}
