package dao;

import entity.Currency;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("currencyPU");

    /*
        public List<String> getAllCurrencyCodes() throws Exception {

        List<String> codes = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        try {

            List<Currency> currencies = em.createQuery(
                    "SELECT c FROM Currency c ORDER BY c.abbreviation",
                    Currency.class
            ).getResultList();

            for (Currency c : currencies) {
                codes.add(c.getAbbreviation() + " - " + c.getName());
            }

        } catch (Exception e) {
            throw new Exception("Database unavailable: " + e.getMessage(), e);
        } finally {
            em.close();
            System.out.println("Fetched currencies from DB: " + codes);

        }

        return codes;
    }
     */

    public List<String> getAllCurrencyCodes() throws Exception {

        List<String> codes = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        try {

            List<Currency> currencies = em.createQuery(
                    "SELECT c FROM Currency c ORDER BY c.abbreviation",
                    Currency.class
            ).getResultList();

            for (Currency c : currencies) {
                codes.add(c.getAbbreviation() + " - " + c.getName());
            }

        } catch (Exception e) {
            throw new Exception("Database unavailable: " + e.getMessage(), e);
        } finally {
            em.close();
            System.out.println("Fetched currencies from DB: " + codes);

        }

        return codes;
    }


    public double getRate(String abbreviation) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {

            Currency currency = em.find(Currency.class, abbreviation);

            if (currency == null) {
                throw new Exception("Currency not found");
            }

            return currency.getRateToUsd();

        } catch (Exception e) {
            throw new Exception("Database unavailable: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // New method required for Step 2 (insert)
    public void insertCurrency(Currency currency) throws Exception {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(currency);
            tx.commit();

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw new Exception("Insert failed: " + e.getMessage(), e);

        } finally {
            em.close();
        }
    }
}
