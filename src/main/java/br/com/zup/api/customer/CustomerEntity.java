package br.com.zup.api.customer;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.zup.api.comic.ComicEntity;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @OneToMany (mappedBy = "customer")
    @JsonManagedReference
    private Set<ComicEntity> vehicles;


    public CustomerEntity() {
    }

    public CustomerEntity(int id, String firstName, String email, String cpf, LocalDateTime birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ComicEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<ComicEntity> vehicles) {
        this.vehicles = vehicles;
    }

}
