package com.lahib.config;

import com.lahib.data.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Adil on 3/14/2017.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
       try {
           Configuration configuration = new Configuration();
           configuration.addAnnotatedClass(Account.class);
           configuration.addAnnotatedClass(AccountType.class);
           configuration.addAnnotatedClass(Address.class);
           configuration.addAnnotatedClass(Bank.class);
           configuration.addAnnotatedClass(Bond.class);
           configuration.addAnnotatedClass(Budget.class);
           configuration.addAnnotatedClass(Credential.class);
           configuration.addAnnotatedClass(Currency.class);
           configuration.addAnnotatedClass(Market.class);
           configuration.addAnnotatedClass(Investment.class);
           configuration.addAnnotatedClass(Market.class);
           configuration.addAnnotatedClass(Portfolio.class);
           configuration.addAnnotatedClass(Stock.class);
           configuration.addAnnotatedClass(Transaction.class);
           configuration.addAnnotatedClass(User.class);

           return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
       }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("Can not build HIbernate SessionFactory");
       }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
