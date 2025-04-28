package cart.service.impl;

import java.util.List;

import cart.dao.UserListDAO;
import cart.dao.impl.UserListDaoImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserListService;

public class UserListServiceImpl implements UserListService{
	UserListDAO userListDAO=new UserListDaoImpl();
	@Override
	public List<UserDTO> findAllUsers() {
		return userListDAO.findAllUsers().stream().map(this::transferToDTO).toList();
	}
	public UserDTO transferToDTO(User user) {
		return new UserDTO(user.getId(),user.getUsername(),user.getEmail(),user.getCompleted());
	}
}
