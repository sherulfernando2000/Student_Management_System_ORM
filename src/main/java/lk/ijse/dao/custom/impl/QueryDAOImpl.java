package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.QueryDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class QueryDAOImpl implements QueryDAO {
    public Object[] getProgramPaymentDetails(String studentId, String programId) {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            // Native SQL Query
            String sql = "SELECT " +
                    "p.fee, " +
                    "r.upfrontpayment, " +
                    "SUM(pay.upfrontpayment) " +
                    "FROM Registration r " +
                    "JOIN Program p ON r.program_pId = p.pId " +
                    "JOIN Student s ON r.student_s_id = s.s_id " +
                    "JOIN Payment pay ON s.s_id = pay.student_s_id " +
                    "WHERE s.s_id = ? AND p.pName = ? " +
                    "GROUP BY p.fee, r.upfrontpayment";

            Query<Object[]> query = session.createNativeQuery(sql, Object[].class);
            query.setParameter(1, studentId);
            query.setParameter(2, programId);

            Object[] result = query.uniqueResult();

            return result;
        } finally {
            session.close();
        }
    }
}
