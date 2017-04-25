package com.mhmt.dao.user.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mhmt.dao.user.VertificationTokenRepository;
import com.mhmt.domain.user.User;
import com.mhmt.domain.user.VerificationToken;

@Repository
@Transactional
public class VerificationTokenRepositoryImpl implements VertificationTokenRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public VerificationToken saveVerificationToken(VerificationToken verificationToken) {
		entityManager.persist(verificationToken);
		return verificationToken;
	}

	@Override
	public VerificationToken updateVerificationToken(VerificationToken verificationToken) {
		VerificationToken updateVerificationToken = entityManager.merge(verificationToken);
		entityManager.flush();
		return updateVerificationToken;
	}

	@Override
	public VerificationToken deleteVerificationToken(VerificationToken verificationToken) {
		if (entityManager.contains(verificationToken)) {
			entityManager.refresh(verificationToken);
			return verificationToken;
		}
		VerificationToken deleteToken = findVerificationTokenByToken(verificationToken.getToken());
		entityManager.remove(deleteToken);
		return deleteToken;
	}

	@Override
	public VerificationToken findVerificationTokenByToken(String token) {
		if (token == null || token.trim().length() <= 0) {
			throw new RuntimeException("Invalid token");
		}
		return entityManager.createNamedQuery("VerificationToken.findByToken", VerificationToken.class)
				.setParameter("token", token).getSingleResult();
	}

	@Override
	public VerificationToken findVerificationTokenByUser(User user) {
		if (user == null) 
			return null;
		TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findByUserId", VerificationToken.class);
		typedQuery.setParameter("userId", user.getId());
		return typedQuery.getSingleResult();
	}

	@Override
	public List<VerificationToken> findAllExpiryDateLessThen(Date date) {
		TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findAllExpiryDateLessThan", VerificationToken.class);
		typedQuery.setParameter("expiryDate", date);
		return typedQuery.getResultList();
	}

	@Override
	public boolean deleteAllExpiredSince(Date date) {
		Query query = entityManager.createNamedQuery("VerificationToken.deleteExpiryDateToken");
		int count = query.setParameter("date", date, TemporalType.TIMESTAMP).executeUpdate();
		return count != -1;
	}

}
