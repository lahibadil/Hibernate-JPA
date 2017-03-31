import com.lahib.data.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.lahib.config.HibernateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Adil on 3/14/2017.
 */
public class Application {
    private static Session session = HibernateUtils.getSessionFactory().openSession();

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

           session.flush();

            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static Bond createBond() {
        Bond bond = new Bond();
        bond.setInterestRate(new BigDecimal("123.22"));
        bond.setIssuer("JP Morgan Chase");
        bond.setMaturityDate(new Date());
        bond.setPurchaseDate(new Date());
        bond.setName("Long Term Bond Purchases");
        bond.setValue(new BigDecimal("10.22"));
        return bond;
    }

    private static Stock createStock(){
        Stock stock = new Stock();
        stock.setIssuer("Allen Edmonds");
        stock.setName("Private American Stock Purchases");
        stock.setPurchaseDate(new Date());
        stock.setQuantity(new BigDecimal("1922"));
        stock.setSharePrice(new BigDecimal("100.00"));
        return stock;
    }

    private static Bank createBank() {
        Bank bank = new Bank();
        Address address = new Address();
        bank.setName("First United Federal");

        bank.setAddressType("PRIMARY");
        bank.setCreatedBy("Kevin Bowersox");
        bank.setCreatedDate(new Date());
        bank.setInternational(false);
        bank.setLastUpdatedBy("Kevin Bowersox");
        bank.setLastUpdatedDate(new Date());

        address.setLine1("103 Washington Plaza");
        address.setLine2("Suite 332");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("10000");

        bank.setAddress(address);
        return bank;
    }

    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        user.setCredential(createCredential(user));
        user.setEmail("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedate(new Date());
        return user;
    }

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUsername("test_username");
        credential.setPassword("test_password");
        return credential;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setLine1("101 Address Line");
        address.setLine2("102 Address Line");
        address.setCity("New York");
        address.setState("PA");
        address.setZipCode("10000");
        return address;
    }

    private static com.lahib.data.entities.Transaction createNewBeltPurchase(Account account) {
        com.lahib.data.entities.Transaction beltPurchase = new com.lahib.data.entities.Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType(TransactionType.Debit);
        return beltPurchase;
    }

    private static com.lahib.data.entities.Transaction createShoePurchase(Account account) {
        com.lahib.data.entities.Transaction shoePurchase = new com.lahib.data.entities.Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType(TransactionType.Debit);
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }

    private static Budget createBudget() {
        Budget budget = new Budget();
        budget.setName("a budget");
        budget.setPeriod("march");
        budget.setGoalAmount(new BigDecimal(5000));
        budget.getTransactions().add(createTransaction(createAccount()));
        return budget;
    }

    private static void insertBankWithEmbeddedAddress() {
        session.beginTransaction();
        Bank bank = new Bank();
        Address address = new Address();
        bank.setName("BMCE");
        bank.setCreatedBy("Adil");
        bank.setLastUpdatedBy("Adil");
        bank.setInternational(true);
        bank.setCreatedDate(new Date());
        bank.setLastUpdatedDate(new Date());

        address.setCity("FES");
        address.setState("FM");
        address.setLine1("HAY SAADA");
        address.setLine2("Hay Adarissa");
        address.setZipCode("30020");

        bank.setAddress(address);
        bank.getContacts().put("Manager", "OTHMANE");
        bank.getContacts().put("Agent", "AIDA");
        session.save(bank);
        session.getTransaction().commit();
        Bank dbBank = session.get(Bank.class, bank.getId());
        System.out.println("the bank id is : " + dbBank.getId().toString());
    }

    private static void insertCredenialWithUser() {
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setFirstName("nabil");
        user.setLastName("buuren");
        user.setBirthDate(new Date());
        user.setEmail("nabil.buuren@gmail.com");
        user.setCreatedDate(new Date());
        user.setCreatedBy("nabil");
        user.setLastUpdatedate(new Date());
        user.setLastUpdatedBy("nabil");

        Credential credential = new Credential();
        credential.setUsername("nabil");
        credential.setPassword("password");

        credential.setUser(user);
        user.setCredential(credential);

        session.save(credential);
        transaction.commit();
        session.refresh(credential);
        session.refresh(user);


        System.out.println("the user id is  : " + credential.getUser().getUserId());


    }

    private static Account createAccount() {
        Account account = new Account();
        account.setName("Adil");
        account.setCreatedBy("Adil");
        account.setCreatedDate(new Date());
        account.setCreatedBy("Adil");
        account.setOpenDate(new Date());
        account.setInitialBalance(new BigDecimal(1000));
        account.setCurrentBalance(new BigDecimal(2000));
        account.setLastUpdatedBy("Adil");
        account.setLastUpdatedDate(new Date());
        account.setCloseDate(new Date());

        return account;

    }

    private static com.lahib.data.entities.Transaction createTransaction(Account account) {
        com.lahib.data.entities.Transaction transaction = new com.lahib.data.entities.Transaction();
        transaction.setTitle("first transaction");
        transaction.setCreatedBy("Adil");
        transaction.setCreatedDate(new Date());
        transaction.setLastUpdatedBy("adil");
        transaction.setLastUpdatedDate(new Date());
        transaction.setInitialBalance(new BigDecimal(2000));
        transaction.setAmount(new BigDecimal(200));
        transaction.setClosingBalance(new BigDecimal(1800));
        transaction.setTransactionType(TransactionType.Withdrawl);
        transaction.setAccount(account);
        return transaction;
    }
}
