package com.group.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private ActiveStatus active;
    private double balance;
    public enum ActiveStatus {
        YES,
        NO
    }
}
