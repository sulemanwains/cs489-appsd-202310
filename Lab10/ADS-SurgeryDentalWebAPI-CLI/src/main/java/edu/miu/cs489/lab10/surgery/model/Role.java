package edu.miu.cs489.lab10.surgery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(
            name="role_users",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "roleId")}
    )
    private List<User> users;
}
