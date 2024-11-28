package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.List;

public interface UserBO extends SuperBO {
    /*public UserDTO getAll(String userNameText);*/


    User searchUserbyName(String userNameText);

    public void intializeDefaultUser();

    boolean saveUser(User userDTO);

    List<UserDTO> getAllUser();

    boolean deleteUser(String userName);

    boolean updateUserPassword(String newpassword, String userName);

    boolean updateUser(User user);
    public boolean updateUser(User user, String firstUserName);

}
