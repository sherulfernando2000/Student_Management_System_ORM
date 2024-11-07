package lk.ijse;

import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


     /*
            public boolean save(Registration registration) {
            Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
            Transaction tx = session.beginTransaction();

            try {
                // Step 1: Save the Registration entity
                session.save(registration);

                // Step 2: Retrieve the associated Payment entity from Registration
                Payment payment = registration.getPayment();

                // Step 3: Update the balance and paid amount in Payment
                if (payment != null) {
                    // Update the balance in Payment with the advanced amount from Registration
                    payment.setBalance(payment.getBalance() + registration.getAdvanced()); // Add advanced amount to balance

                    // Calculate and update the paid amount
                    double newPaidAmount = payment.getAmount() - registration.getAdvanced(); // Calculate new paid amount
                    payment.setPaidAmount(newPaidAmount); // Set the updated paid amount

                    // Update the Payment entity in the database
                    session.update(payment); // Save the updated Payment entity
                }

                // Commit the transaction
                tx.commit();
                return true;

            } catch (Exception e) {
                // Rollback the transaction in case of an error
                if (tx != null) {
                    tx.rollback();
                }

                return false;

            } finally {
                // Close the session to release resources
                session.close();
            }
        }

*/


 /*
        package lk.ijse.entity;

        import jakarta.persistence.Entity;
        import jakarta.persistence.Id;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;


        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @Entity
        public class Payment {

            @Id
            private String paymentId;
            private double amount;
            private double paidAmount;
            private double balance;

            public Payment(String paymentId, double amount) {
                this.paymentId = paymentId;
                this.amount = amount;
            }
            @Override
            public String toString() {
                return " " +paymentId ;
            }

        }


        */


/*
        @FXML
        void btnsaveaction(ActionEvent event) {
            try {
                // Validate registration ID
                String regId = registrationid.getText();
                if (regId == null || regId.trim().isEmpty()) {
                    showAlert("Error", "Registration ID cannot be empty.", Alert.AlertType.WARNING);
                    return; // Early exit if validation fails
                }

                // Validate payment
                double payment;
                try {
                    payment = Double.parseDouble(this.payment.getText());
                } catch (NumberFormatException e) {
                    showAlert("Error", "Invalid payment amount. Please enter a valid number.", Alert.AlertType.ERROR);
                    return; // Early exit if validation fails
                }



                // Create RegistrationDTO with validated data
                RegistrationDTO registrationDTO = new RegistrationDTO(regId, payment, selectedDate, course, student, payment1);
                System.out.println("DTO created: " + registrationDTO);

                // Save registration and provide feedback
                boolean isSaved = registrationBo.saveRegistration(registrationDTO);
                if (isSaved) {
                    System.out.println("Registration saved");
                    loadRegistrationTable();
                    showAlert("Success", "Registration saved successfully.", Alert.AlertType.INFORMATION);
                } else {
                    showAlert("Error", "Failed to save registration.", Alert.AlertType.ERROR);
                }

            } catch (Exception e) {
                showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }*/

    }
}