package com.mhmt.validation;

import com.mhmt.web.dto.PasswordDto;
import com.mhmt.web.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches arg0) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext arg1) {

        if (obj.getClass().getSimpleName().equals("UserDto")) {
            UserDto userDto = (UserDto) obj;
            return userDto.getPassword().equals(userDto.getMatchingPassword());
        } else {
            PasswordDto passwordDto = (PasswordDto) obj;
            return passwordDto.getNewPassword().equals(passwordDto.getMatchingPassword());
        }
    }

}
