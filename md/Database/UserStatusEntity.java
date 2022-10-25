package com.testblog.md.Database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_status", schema = "public", catalog = "Blog")
public class UserStatusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStatusEntity that = (UserStatusEntity) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
