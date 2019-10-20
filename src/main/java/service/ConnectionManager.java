package service;

import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Data
public class ConnectionManager {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("students");

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public void startSession() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        this.entityManager = entityManager;
        this.entityTransaction = transaction;
    }

    public void endSession() {
        this.entityTransaction.commit();
        this.entityManager.close();
    }

    public void rollbackSession() {
        this.entityTransaction.rollback();
        this.entityManager.close();
    }
}
