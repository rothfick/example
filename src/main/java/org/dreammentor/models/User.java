package org.dreammentor.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String bio;
    private Double balance = 0.0;

    @OneToMany(mappedBy = "mentor")
    private List<Session> mentorSessions;

    @OneToMany(mappedBy = "podopieczny")
    private List<Session> podopiecznySessions;

}
