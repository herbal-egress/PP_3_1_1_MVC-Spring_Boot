package mvc.spring.boot.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if (id == 0 && user.id == 0) {
            return age == user.age &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(email, user.email);
        }
        return id == user.id;
    }

    @Override
    public int hashCode() {
        if (id == 0) {
            return Objects.hash(name, age, email);
        }
        return id;
    }
}