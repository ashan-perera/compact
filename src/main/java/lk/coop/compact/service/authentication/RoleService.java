package lk.coop.compact.service.authentication;

import lk.coop.compact.dto.authentication.request.RoleSaveRequest;
import lk.coop.compact.dto.authentication.response.RoleResponse;
import lk.coop.compact.entity.authentication.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    RoleResponse findById(String id);

    List<RoleResponse> notDeletedList();

    RoleResponse save(RoleSaveRequest roleSaveRequest);

    RoleResponse update(RoleSaveRequest roleSaveRequest);

}
