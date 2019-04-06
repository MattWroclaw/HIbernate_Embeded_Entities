package sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "pacjent_upo")
public class PacjentUPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String imie;
    @Column
    private String nazwisko;
    @Column
    private String pesel;

    @Embedded
    private OsobaUPO osobaUpoI;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "imieUpoI", column = @Column(name = "imieUpoII")),
            @AttributeOverride(name = "nazwiskoUpoI", column = @Column(name = "nazwiskoUpoII")),
            @AttributeOverride(name = "nrDowoduUpoI", column = @Column(name = "nrDowoduUpoII")),
            @AttributeOverride(name = "dataDodaniaUpoI", column = @Column(name = "dataDodaniaUpoII")),
    })
    private OsobaUPO osobaUpoII;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "imieUpoI", column = @Column(name = "imieUpoIII")),
            @AttributeOverride(name = "nazwiskoUpoI", column = @Column(name = "nazwiskoUpoIII")),
            @AttributeOverride(name = "nrDowoduUpoI", column = @Column(name = "nrDowoduUpoIII")),
            @AttributeOverride(name = "dataDodaniaUpoI", column = @Column(name = "dataDodaniaUpoIII")),
    })
    private OsobaUPO osobaUpoIII;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public OsobaUPO getOsobaUpoI() {
        return osobaUpoI;
    }

    public void setOsobaUpoI(OsobaUPO osobaUpoI) {
        this.osobaUpoI = osobaUpoI;
    }

    public OsobaUPO getOsobaUpoII() {
        return osobaUpoII;
    }

    public void setOsobaUpoII(OsobaUPO osobaUpoII) {
        this.osobaUpoII = osobaUpoII;
    }

    public OsobaUPO getOsobaUpoIII() {
        return osobaUpoIII;
    }

    public void setOsobaUpoIII(OsobaUPO osobaUpoIII) {
        this.osobaUpoIII = osobaUpoIII;
    }

    @Override
    public String toString() {
        String dane = "PacjentUPO{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'';
        if (osobaUpoI != null) {
            dane += ", osobaUpoI=" + osobaUpoI.toString();
        }
        if (osobaUpoII != null) {
            dane += ", osobaUpoII=" + osobaUpoII.toString();
        }
        if (osobaUpoIII != null) {
            dane += ", osobaUpoIII=" + osobaUpoIII.toString();
        }
        dane += '}';
        return dane;
    }
}
