package com.udemy.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name="user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name="user_role_id")
    private Integer userRoleId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable = false)
    private User user;

    @Column(name="role", nullable = false, length = 45)
    private String role;

    public UserRole() {
    }

    public UserRole(Integer userRoleId, User user, String role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
