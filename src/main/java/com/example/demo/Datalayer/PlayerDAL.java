package com.example.demo.Datalayer;

import com.example.demo.Entity.PlayerEntity;
import com.example.demo.Entity.Player_Tournament;
import com.example.demo.Entity.TournamentEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDAL implements IPlayer {

    private PlayerDTO playerDTO;

    private static EntityManagerFactory factory;
    private EntityManager em = null;
    private EntityTransaction transaction = null;

    //Spelers ophalen uit de database
    public PlayerDTO GetPlayer(PlayerDTO player){
        factory = Persistence.createEntityManagerFactory("user-system");
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
            factory.close();
            em.close();
            transaction = null;
        }

        return playerDTO;
    }

    //Spelers toevoegen aan de database
    public void AddPlayer(PlayerDTO player){
        factory = Persistence.createEntityManagerFactory("user-system");
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
            factory.close();
            em.close();
            transaction = null;
        }
    }

    public void UpdatePlayer(int ID, PlayerDTO player){
        factory = Persistence.createEntityManagerFactory("user-system");
        em = factory.createEntityManager();
        transaction = em.getTransaction();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<PlayerEntity> update = builder.createCriteriaUpdate(PlayerEntity.class);
        Root<PlayerEntity> root = update.from(PlayerEntity.class);

        if (player.getUsername() != "" && player.getUsername() != null){
            update.set("username", player.getUsername());
        }
        if (player.getPassword() != "" && player.getPassword() != null){
            update.set("password", player.getPassword());
        }
        update.set("elo", player.getElo());

        update.where(builder.equal(root.get("Id"), ID));

        try{
            transaction.begin();
            em.createQuery(update).executeUpdate();
            transaction.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        finally {
            factory.close();
            em.close();
            transaction = null;
        }
    }

    public void DeletePlayer(int ID){
        factory = Persistence.createEntityManagerFactory("user-system");
        em = factory.createEntityManager();
        transaction = em.getTransaction();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<PlayerEntity> delete = builder.createCriteriaDelete(PlayerEntity.class);
        Root<PlayerEntity> root = delete.from(PlayerEntity.class);

        delete.where(root.get("Id").in(ID));

        try{
            transaction.begin();
            em.createQuery(delete).executeUpdate();
            transaction.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        finally {
            factory.close();
            em.close();
            transaction = null;
        }
    }

    public PlayerDTO GetPlayerTournament(int ID){
        factory = Persistence.createEntityManagerFactory("user-system");
        em = factory.createEntityManager();
        transaction = em.getTransaction();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PlayerEntity> query = builder.createQuery(PlayerEntity.class);
        Root<PlayerEntity> root = query.from(PlayerEntity.class);
        Root<Player_Tournament> PTroot = query.from(Player_Tournament.class);
        Root<TournamentEntity> Troot = query.from(TournamentEntity.class);
        Join<PlayerEntity, Player_Tournament> betweenJoin = root.join(String.valueOf(Player_Tournament.class), JoinType.INNER);
        Join<PlayerEntity, TournamentEntity> endJoin = root.join(String.valueOf(TournamentEntity.class), JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("Id"), ID));
        predicates.add(builder.equal(PTroot.get("Id"), ID));


//        query.multiselect(,
//                )

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
            factory.close();
            em.close();
            transaction = null;
        }

        return playerDTO;
    }
}
