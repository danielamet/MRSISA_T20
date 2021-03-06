package com.isamrs.backend.service;

import com.isamrs.backend.dto.UpdateProfileDTO;
import com.isamrs.backend.dto.UserDTO;
import com.isamrs.backend.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    User getUser(String email);
    User getUserEmailAndPassword(String email,String password);
    User UserDTOToUser(UserDTO userDTO);
    boolean saveUser(User u);
    User UpdateDTOtoUser(UpdateProfileDTO profileDTO);
    boolean update(User u);
}
