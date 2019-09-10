package com.vlad.alpha1.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "alphausers")
public class AlphaUser {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Blocked")
    private boolean blocked = false;

}
