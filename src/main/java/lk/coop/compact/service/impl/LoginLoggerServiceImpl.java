package lk.coop.compact.service.impl;

import lk.coop.compact.converter.DateFormatConverter;
import lk.coop.compact.dto.request.LoginSaveRequest;
import lk.coop.compact.dto.response.LocationResponse;
import lk.coop.compact.dto.response.LoginResponse;
import lk.coop.compact.dto.response.RoleResponse;
import lk.coop.compact.dto.response.UserResponse;
import lk.coop.compact.entity.LoginLogger;
import lk.coop.compact.entity.Role;
import lk.coop.compact.entity.User;
import lk.coop.compact.repository.LoginLoggerRepository;
import lk.coop.compact.repository.UserRepository;
import lk.coop.compact.service.LoginLoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LoginLoggerServiceImpl implements LoginLoggerService {

    @Autowired
    LoginLoggerRepository loginLogger;

    @Autowired
    UserRepository userRepository;

    @Override
    public LoginResponse save(LoginSaveRequest saveRequest) {
        User user = convertUserSave(saveRequest.getUserName());
        if (user == null) {
            return null;
        } else {
            LoginLogger save = this.loginLogger.save(convert(saveRequest));
            return convertLogin(save);
        }
    }

    private LoginLogger convert(LoginSaveRequest loginSaveRequest) {
        LoginLogger loginLogger = new LoginLogger();
        try {
            loginLogger.setIpAddress(loginSaveRequest.getIpAddress());
            loginLogger.setUser(convertUserSave(loginSaveRequest.getUserName()));
            loginLogger.setLoginType(loginSaveRequest.getLoginType());
        } catch (Exception e) {
            log.error("LoginLogger Save Convert {} ", loginSaveRequest.getUserName());
            return null;
        }
        return loginLogger;
    }

    //SAVE USER
    private User convertUserSave(String userName) {
        try {
            User user = this.userRepository.findByUsername(userName);
            if (user == null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
            return user;
        } catch (UsernameNotFoundException e) {
            log.error("User Name NotFound {} ", userName);
            return null;
        }
    }

    //LOGIN RESPONSE CONVERT
    private static LoginResponse convertLogin(LoginLogger loginLogger) {
        DateFormatConverter df = new DateFormatConverter();
        if (loginLogger == null) {
            return null;
        }

        return new LoginResponse(loginLogger.getId(), loginLogger.getIpAddress(), convertUser(loginLogger.getUser()), loginLogger.getLoginType(),
                df.patternDateTime(loginLogger.getCreatedDateTime()));
    }

    private static UserResponse convertUser(User user) {
        DateFormatConverter df = new DateFormatConverter();
        if (user == null) {
            return null;
        }

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getName(), user.getBusinessTitle(),
                user.getEpfNo(), convertRole(user.getRoles()));
    }

    //ROLE RESPONSE CONVERT
    private static List<RoleResponse> convertRole(List<Role> roles) {
        List<RoleResponse> roleResList = new ArrayList<>();
        for (Role role : roles) {
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(role.getId());
            roleResponse.setName(role.getName());
            roleResponse.setDescription(role.getDescription());
            roleResList.add(roleResponse);
        }

        return roleResList;
    }

}
