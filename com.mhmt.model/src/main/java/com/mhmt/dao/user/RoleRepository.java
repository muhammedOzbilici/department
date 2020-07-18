package com.mhmt.dao.user;

import com.mhmt.domain.user.Role;

import java.util.List;

public interface RoleRepository {
    Role saveRole(Role role);

    Role updateRole(Role role);

    Role deleteRole(Role role);

    Role findRoleById(Long id);

    Role findRoleByName(String roleName);

    List<Role> findAllRoles();
}
