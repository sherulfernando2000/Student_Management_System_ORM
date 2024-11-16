package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Payment;

public interface PaymentBO extends SuperBO {
    public Object[] getProgramPaymentDetails(String studentId, String programId);

    public boolean savePayment(Payment payment);
}
