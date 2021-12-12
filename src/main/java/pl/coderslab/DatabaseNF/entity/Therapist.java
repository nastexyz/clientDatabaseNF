package pl.coderslab.DatabaseNF.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "therapists")
public class Therapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String therapistFirstName;
    @NotBlank
    private String therapistLastName;
    @NotBlank
    @Size(min = 5, message = "Login musi posiadać minimum 5 znaków")
    private String login;
    private String password;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTherapistFirstName() {
        return therapistFirstName;
    }
    public void setTherapistFirstName(String therapistFirstName) {
        this.therapistFirstName = therapistFirstName;
    }

    public String getTherapistLastName() {
        return therapistLastName;
    }
    public void setTherapistLastName(String therapistLastName) {
        this.therapistLastName = therapistLastName;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Osoba obsługująca: " +
                "id: '" + id +
                ", imię: '" + therapistFirstName +
                ", nazwisko: '" + therapistLastName +
                ", login: '" + login +
                ", hasło: '" + password;
    }
}
