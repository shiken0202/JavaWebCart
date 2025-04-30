package cart.service;

import cart.model.dto.UserDTO;

public interface UserLoginService {
	//驗證是否登入成功
	UserDTO login(String username,String password , String  authcode, String sessionAuthCode);
}
