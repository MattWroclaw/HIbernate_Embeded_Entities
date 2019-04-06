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


}
