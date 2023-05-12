package lk.coop.compact.service;

import lk.coop.compact.dto.request.LoginSaveRequest;
import lk.coop.compact.dto.response.LoginResponse;

public interface LoginLoggerService {

    LoginResponse save(LoginSaveRequest request);

}
