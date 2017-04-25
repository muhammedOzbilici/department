package com.mhmt.dao.user;

import java.util.Date;
import java.util.List;

import com.mhmt.domain.user.User;
import com.mhmt.domain.user.VerificationToken;

public interface VertificationTokenRepository {
	VerificationToken saveVerificationToken(VerificationToken verificationToken);
	VerificationToken updateVerificationToken(VerificationToken verificationToken);
	VerificationToken deleteVerificationToken(VerificationToken verificationToken);
	VerificationToken findVerificationTokenByToken(String token);
	VerificationToken findVerificationTokenByUser(User user);

	List<VerificationToken> findAllExpiryDateLessThen(Date date);
	
	boolean deleteAllExpiredSince(Date date);
}
