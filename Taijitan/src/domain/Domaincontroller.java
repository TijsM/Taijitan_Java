package domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.SessionDao;
import repository.SessionDaoJpa;
import repository.UserDao;
import repository.UserDaoJpa;

import java.util.List;

public class Domaincontroller {

    private UserDao userDao;
    private SessionDao sessionDao;

    public Domaincontroller(){

        setUserDao(new UserDaoJpa());
        setSessionDao(new SessionDaoJpa());
    }

    public void setUserDao(UserDaoJpa udj){

        this.userDao = udj;
    }

    public  void setSessionDao(SessionDao sd){

        this.sessionDao = sd;
    }

    public List<User> getAllUsers(){
        List<User> users = userDao.findAll();
        for (User u:users)
        {
            System.out.println(u.toString());
        }
        return users;
    }
    public ObservableList<User> GetAllUsersFX()
    {
        return FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(getAllUsers()));
    }

    public List<Session> getAllSessions(){
        List<Session> sessions = sessionDao.findAll();

        for(Session s : sessions){
            System.out.printf(s.toString());
        }

        return sessions;
    }
}
