package com.mhmt.dao.user;

import java.util.List;

import com.mhmt.domain.user.Role;

public interface RoleRepository {
	Role saveRole(Role role);
	Role updateRole(Role role);
	Role deleteRole(Role role);
	Role findRoleById(Long id);
	Role findRoleByName(String roleName);

	List<Role> findAllRoles();
}
