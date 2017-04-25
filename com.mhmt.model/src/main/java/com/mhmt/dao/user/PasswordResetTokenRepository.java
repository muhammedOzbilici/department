package com.mhmt.dao.user;

import java.util.Date;
import java.util.List;

import com.mhmt.domain.user.PasswordResetToken;
import com.mhmt.domain.user.User;

public interface PasswordResetTokenRepository {
	PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken);
	PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken);
	PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken);
	PasswordResetToken findPasswordResetTokenByToken(String token);
	PasswordResetToken findPasswordResetTokenByUser(User user);
	PasswordResetToken findPasswordResetTokenFindById(Long id);
	
	List<PasswordResetToken> findAllByExpiryDateLessThan(Date date);
	
	boolean deleteAllExpiredSince(Date date);


}
