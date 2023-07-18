package lk.coop.compact.service.authentication.impl;

import lk.coop.compact.dto.authentication.request.RoleSaveRequest;
import lk.coop.compact.dto.authentication.response.RoleResponse;
import lk.coop.compact.entity.authentication.Role;
import lk.coop.compact.repository.authentication.RoleRepository;
import lk.coop.compact.service.authentication.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        Role role = roleRepository.findByName(name);
        return role;
    }

    @Override
    public RoleResponse findById(String id) {
        return convertRole(roleRepository.findById(id).get());
    }

    @Override
    public List<RoleResponse> notDeletedList() {

        return roleRepository.findAll()
                .stream().map(RoleServiceImpl::convertRole)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse save(RoleSaveRequest roleSaveRequest) {

        return convertRole(roleRepository.save(convertReq(roleSaveRequest, false)));
    }

    @Override
    public RoleResponse update(RoleSaveRequest roleSaveRequest) {

        return convertRole(roleRepository.save(convertReq(roleSaveRequest, true)));
    }


    static Role convertReq(RoleSaveRequest roleSaveRequest, boolean update) {

        Role role = new Role();
        role.setDescription(roleSaveRequest.getDescription());
        role.setName(roleSaveRequest.getName());

        if (update) {
            role.setId(roleSaveRequest.getId());
        }

        return role;
    }

    static RoleResponse convertRole(Role role) {
        if (role == null) {
            return null;
        }
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setDescription(role.getDescription());
        return roleResponse;

    }

}
