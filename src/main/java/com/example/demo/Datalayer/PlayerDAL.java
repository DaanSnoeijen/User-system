package com.example.demo.Datalayer;

import com.example.demo.Entity.PlayerEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PlayerEntity> query = builder.createQuery(PlayerEntity.class);
        Root<PlayerEntity> root = query.from(PlayerEntity.class);

        Predicate predicateUsername
                = builder.like(root.get("username"), player.getUsername());
        Predicate predicatePassword
                = builder.like(root.get("password"), player.getPassword());
        Predicate predicateLogIn
                = builder.and(predicateUsername, predicatePassword);

        query.select(root).where(predicateLogIn);

        try{
            transaction.begin();
            PlayerEntity entity = em.createQuery(query).getSingleResult();
            playerDTO = new PlayerDTO(entity);
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
