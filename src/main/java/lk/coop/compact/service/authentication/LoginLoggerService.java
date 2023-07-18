package lk.coop.compact.service.authentication;

import lk.coop.compact.dto.authentication.request.LoginSaveRequest;
import lk.coop.compact.dto.authentication.response.LoginResponse;

public interface LoginLoggerService {

    LoginResponse save(LoginSaveRequest request);

}
