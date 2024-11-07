package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    void placeRegister(List<RegistrationDTO> registrationDTOList);

    int getCurrentRegistrationId();
}
