package com.example.demo.Datalayer;

import com.example.demo.Entity.PlayerEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Component
public class PlayerDAL implements IPlayer {

    private PlayerDTO playerDTO;

    private final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("user-system");
    private EntityManager em = null;
    private EntityTransaction transaction = null;

    //Spelers ophalen uit de database
    public PlayerDTO GetPlayer(PlayerDTO player){
        em = factory.createEntityManager();
        transaction = em.getTransaction();

        try{
            transaction.begin();
            transaction.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        finally {
            em.close();
            transaction = null;
        }

        return playerDTO;
    }

    //Spelers toevoegen aan de database
    public void AddPlayer(PlayerDTO player){
        em = factory.createEntityManager();
        transaction = em.getTransaction();

        try{
            transaction.begin();
            em.persist(new PlayerEntity(player));
            transaction.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        finally {
            em.close();
            transaction = null;
        }
    }
}
