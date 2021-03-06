package com.mhmt.domain.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "VerificationToken")
@NamedQueries({
        @NamedQuery(name = "VerificationToken.findByToken", query = "SELECT v FROM VerificationToken v WHERE v.token = :token"),
        @NamedQuery(name = "VerificationToken.findByUserId", query = "SELECT v FROM VerificationToken v"
                + " WHERE v.userId = :userId"),
        @NamedQuery(name = "VerificationToken.findAllExpiryDateLessThan", query = "SELECT v "
                + " FROM VerificationToken v WHERE v.expiryDate < :expiryDate"),
        @NamedQuery(name = "VerificationToken.deleteExpiryDateToken", query = "SELECT v "
                + " FROM VerificationToken v WHERE v.date < :date")
})
public class VerificationToken {
    @Transient
    private final int EXPIRY_DATE = 60 * 24;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public VerificationToken() {
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    public VerificationToken(User user, String token) {
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    private Date calculateExpiryDate(int eXPIRY_DATE2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRY_DATE);

        return new Date(calendar.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        VerificationToken other = (VerificationToken) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
