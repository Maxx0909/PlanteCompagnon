package pack.plantecompagnon.src.service;

import java.util.Date;
import java.util.ArrayList;

//pour l'utilisation du thread asynchrone
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pack.plantecompagnon.src.DAO.UserDao;
import pack.plantecompagnon.src.model.GenderList;
import pack.plantecompagnon.src.model.PlantWishlist;
import pack.plantecompagnon.src.model.User;
import pack.plantecompagnon.src.model.UserPlant;

//librairie pour hasher le mot de passe
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private final UserDao userDao;

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

            User user = new User(pseudo, email, birthDate, hashPassword, newGender, city, picture);

            userDao.insert(user);
       });
    }

    public void deleteAccount(User user){
        executorService.execute(() -> userDao.delete(user));
    }

    public void modifyInformation(User user, String pseudo, String email, Date birthDate, String password, GenderList gender, String city, String picture){
        executorService.execute(() -> {
            user.setPseudo(pseudo);
            user.setEmail(email);
            user.setBirthDate(birthDate);
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

    public int getNumberUserPlant(String pseudo){
        return userDao.getCountUserPlant(pseudo);
    }

    public ArrayList<UserPlant> getAllUserPlant(String pseudo){

        return new ArrayList<>(userDao.getAllUserPlant(pseudo));
    }

    public ArrayList<PlantWishlist> getWhishList(String pseudo){
        return new ArrayList<>(userDao.getWhishList(pseudo));
    }

    /*****
     *
     *
     * ATTENTION BIEN APPELER CETTE MéTHODE APRèS S'ETRE SERVIT DU DAO SINON FUITE MéMOIRE !!!
     *
     */
    public void shutdownExecutor() {
        executorService.shutdown();
    }
}
