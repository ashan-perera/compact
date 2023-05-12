package lk.coop.compact.service;

import lk.coop.compact.dto.request.RoleSaveRequest;
import lk.coop.compact.dto.response.RoleResponse;
import lk.coop.compact.entity.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    RoleResponse findById(String id);

    List<RoleResponse> notDeletedList();

    RoleResponse save(RoleSaveRequest roleSaveRequest);

    RoleResponse update(RoleSaveRequest roleSaveRequest);

}
