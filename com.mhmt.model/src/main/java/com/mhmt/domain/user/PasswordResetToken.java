package com.mhmt.domain.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "PasswordResetToken")
@NamedQueries({
        @NamedQuery(name = "PasswordResetToken.findByToken", query = "SELECT p FROM PasswordResetToken p WHERE p.token = :token"),
        @NamedQuery(name = "PasswordResetToken.findByUserId", query = "SELECT p FROM PasswordResetToken p WHERE p.user.id = :userId"),
        @NamedQuery(name = "PasswordResetToken.deleteExpiryDateToken", query = "DELETE  FROM PasswordResetToken p WHERE p.expiryDate <= :date"),
        @NamedQuery(name = "PasswordResetToken.findAllByExpiryDateLessThan", query = "SELECT p FROM PasswordResetToken p WHERE p.expiryDate <= :expiryDate")
})
public class PasswordResetToken {
    @Transient
    private final int EXPIRY_DATE = 24 * 60;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String token;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(foreignKeyDefinition = "user_fk"))
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public PasswordResetToken() {
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    public PasswordResetToken(User user, String token) {
        this.user = user;
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    private Date calculateExpiryDate(int eXPIRY_DATE2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, eXPIRY_DATE2);
        return new Date(calendar.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PasswordResetToken other = (PasswordResetToken) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
