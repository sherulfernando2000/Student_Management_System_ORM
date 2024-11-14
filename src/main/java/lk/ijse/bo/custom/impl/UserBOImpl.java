package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Users);

   /* @Override
    public UserDTO getAll(String userNameText) {
        return userDAO.getAll
    }
*/
    @Override
    public User searchUserbyName(String userNameText) {
        return userDAO.searchByName(userNameText);
    }

    public void intializeDefaultUser() {
        userDAO.initializeDefaultUser();
    }

    @Override
    public boolean saveUser(User userDTO) {
        return userDAO.save(userDTO);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users =  userDAO.getAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user.getUserName(),user.getPassword(),user.getRole(), user.getEmail());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public boolean deleteUser(String userName) {
        return userDAO.delete(userName);
    }

    @Override
    public boolean updateUserPassword(String newpassword, String userName) {

        return userDAO.updatePassword(newpassword, userName);
    }
}
