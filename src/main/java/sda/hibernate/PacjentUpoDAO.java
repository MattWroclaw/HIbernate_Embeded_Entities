package sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.entity.OsobaUPO;
import sda.hibernate.entity.PacjentUPO;

import java.sql.Date;
import java.time.LocalDate;

public class PacjentUpoDAO {
    public PacjentUPO create(String imie, String nazwisko, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        PacjentUPO nowyPacjent = new PacjentUPO();
        nowyPacjent.setImie(imie);
        nowyPacjent.setNazwisko(nazwisko);
        nowyPacjent.setPesel(pesel);
        session.persist(nowyPacjent);
        session.flush();
        tr.commit();
        session.close();
        return nowyPacjent;
    }

    public PacjentUPO createWithUpoI(String imie, String nazwisko, String pesel, OsobaUPO osobaUpoI) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        PacjentUPO nowyPacjent = new PacjentUPO();
        nowyPacjent.setImie(imie);
        nowyPacjent.setNazwisko(nazwisko);
        nowyPacjent.setPesel(pesel);
        osobaUpoI.setDataDodaniaUpoI(Date.valueOf(LocalDate.now()));
        nowyPacjent.setOsobaUpoI(osobaUpoI);
        session.persist(nowyPacjent);
        session.flush();
        tr.commit();
        session.close();
        return nowyPacjent;
    }

    public PacjentUPO readByPesel(String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PacjentUPO pacjentDB = session.createQuery("From PacjentUPO p WHERE p.pesel=:pesel", PacjentUPO.class).
                setParameter("pesel", pesel).getSingleResult();
        session.close();
        return pacjentDB;
    }

    public void update(String imie, String nazwisko, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("UPDATE PacjentUPO p Set p.imie=:imie, p.nazwisko=:nazwisko WHERE p.pesel=:pesel")
                .setParameter("imie", imie)
                .setParameter("nazwisko", nazwisko)
                .setParameter("pesel", pesel)
                .executeUpdate();
        tr.commit();
        session.close();
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        PacjentUPO pacjentUPO = new PacjentUPO();
        pacjentUPO.setId(id);
        session.delete(pacjentUPO);
        tr.commit();
        session.close();
    }

    public void createOrUpdateUPO(OsobaUPO osobaUPO, String pesel, int l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        PacjentUPO pacjentDB = session.createQuery("From PacjentUPO p WHERE p.pesel=:pesel",
                PacjentUPO.class).
                setParameter("pesel", pesel).getSingleResult();
        if (l == 1) {
            pacjentDB.setOsobaUpoI(osobaUPO);
        } else if (l == 2) {
            pacjentDB.setOsobaUpoII(osobaUPO);
        } else if (l == 3) {
            pacjentDB.setOsobaUpoIII(osobaUPO);
        }

        session.merge(pacjentDB);
        tr.commit();
        session.close();
    }

    public boolean verifyUPO(OsobaUPO osobaUPO, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PacjentUPO pacjentDB = session.createQuery("From PacjentUPO p WHERE p.pesel=:pesel",
                PacjentUPO.class).
                setParameter("pesel", pesel).getSingleResult();
        boolean status = false;
        if (osobaUPO.equals(pacjentDB.getOsobaUpoI())) {
            status = true;
        }else if (osobaUPO.equals(pacjentDB.getOsobaUpoII())) {
            status = true;
        }else if (osobaUPO.equals(pacjentDB.getOsobaUpoIII())) {
            status = true;
        }
        session.close();
        return status;
    }
}
