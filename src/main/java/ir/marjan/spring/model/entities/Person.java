package ir.marjan.spring.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DEFAULT_SEQ")
    @SequenceGenerator(name = "DEFAULT_SEQ",sequenceName = "PERSONS_SEQ",allocationSize = 1)
    private long id ;

    @Basic
    @Column(name = "name",columnDefinition = "VARCHAR2(20)")
    private String name ;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
