package sda.hibernate;

import sda.hibernate.entity.OsobaUPO;
import sda.hibernate.entity.PacjentUPO;

public class Zadanie2roz {
    public static void main(String[] args) {
        //dodajemy nowego pacjenta
        PacjentUpoDAO pacjentUpoDAO = new PacjentUpoDAO();
        pacjentUpoDAO.create("Adam","Kowalski","23421234214");

        //dodajemy nowego pacjenta z osoba upowazniona I
        OsobaUPO osobaUPOI=new OsobaUPO();
        osobaUPOI.setImieUpoI("Marek");
        osobaUPOI.setNazwiskoUpoI("Nowak");
        osobaUPOI.setNrDowoduUpoI("ASD23412");
        pacjentUpoDAO.createWithUpoI("Ala","Mila","23456511123",osobaUPOI);

        //szukamy pacjenta
        PacjentUPO pacjentUPO = pacjentUpoDAO.readByPesel("23421234214");
        System.out.println("znaleziono pacjenta: "+pacjentUPO.toString());
        PacjentUPO pacjentUPO2 = pacjentUpoDAO.readByPesel("23456511123");
        System.out.println("znaleziono pacjenta: "+pacjentUPO2.toString());

        //update danych pacjenta
        pacjentUpoDAO.update("noweImie","noweNazwisko","23456511123");

        //usuwanie pacjenta
        pacjentUpoDAO.delete(2L);

        //ustawiamy UPO dla osoby 1
        pacjentUpoDAO.createOrUpdateUPO(osobaUPOI,"23421234214",1);
        //ustawiamy UPO dla osoby 2
        pacjentUpoDAO.createOrUpdateUPO(osobaUPOI,"23421234214",2);
        //ustawiamy UPO dla osoby 3
        pacjentUpoDAO.createOrUpdateUPO(osobaUPOI,"23421234214",3);

        //sprawdzamy verifyUPO
        boolean statusI = pacjentUpoDAO.verifyUPO(osobaUPOI,"23421234214");
        System.out.println("Pacjent posiada upo: "+statusI);

        OsobaUPO osobaUPOI2=new OsobaUPO();
        osobaUPOI2.setImieUpoI("Monika");
        osobaUPOI2.setNazwiskoUpoI("Nowak");
        osobaUPOI2.setNrDowoduUpoI("ASD23412");
        boolean status2 = pacjentUpoDAO.verifyUPO(osobaUPOI2,"23421234214");
        System.out.println("Pacjent posiada upo: "+status2);
    }
}
