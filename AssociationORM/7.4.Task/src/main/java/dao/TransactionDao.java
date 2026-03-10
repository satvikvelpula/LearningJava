package dao;

import entity.Transaction;
import jakarta.persistence.*;

public class TransactionDao {

    private static final EntityManagerFactory emf = CurrencyDao.getEmf();

    public void insertTransaction(Transaction transaction) throws Exception {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            em.persist(transaction);
            tx.commit();

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw new Exception("Transaction insert failed: " + e.getMessage(), e);

        } finally {
            em.close();
        }
    }
}
