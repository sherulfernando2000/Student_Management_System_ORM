package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public Object[] getProgramPaymentDetails(String studentId, String programId);

}
