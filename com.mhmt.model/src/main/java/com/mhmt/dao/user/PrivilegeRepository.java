package com.mhmt.dao.user;

import com.mhmt.domain.user.Privilege;

import java.util.List;

public interface PrivilegeRepository {
    Privilege savePrivilege(Privilege privilege);

    Privilege updatePrivilege(Privilege privilege);

    Privilege deletePrivilege(Privilege privilege);

    Privilege findPrivilegeID(Long id);

    Privilege findPrivilegeByName(String privilegeName);

    List<Privilege> findAllPrivileges();

}
