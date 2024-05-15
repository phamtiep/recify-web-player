package com.swe.recify.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "username", nullable = false)
    private String username;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "role", nullable = false)
    private String role;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.ALL})
    private Set<Playlist> AllPlaylist = new HashSet<Playlist>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.ALL})
    private Set<ViewManager> ViewManager = new HashSet<ViewManager>(0);

    public Set<Playlist> getAllPlaylist() {
        return AllPlaylist;
    }

    public void setAllPlaylist(Set<Playlist> allPlaylist) {
        AllPlaylist = allPlaylist;
    }

    public User() {

    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Set<ViewManager> getViewManager() {
        return ViewManager;
    }

    public void setViewManager(Set<ViewManager> viewManager) {
        ViewManager = viewManager;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

}

