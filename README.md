Digital Student Registration System for The Culinary Academy

Key Features: 🔑
📝 Student and Program Management:

Implemented CRUD operations for managing student records and culinary programs.
🔗 Cascade Types & Relationship Management:

Utilized Hibernate cascade types to ensure proper entity relationships (e.g., One-to-Many for students and courses).
🔒 Secure Authentication:

Integrated BCrypt for secure password encryption and storage.
👥 Role-Based Access Control:

Implemented user role management (e.g., admin, admissions coordinator) with controlled access to functionalities.
🔍 Advanced Querying:

Developed HQL join queries to fetch students enrolled in all culinary programs.
Implemented relationship queries to retrieve students along with their enrolled courses.
⚠️ Custom Exception Handling:

Designed a robust exception handling mechanism for errors during registration and login.
✅ Input Validation:

Ensured data integrity with validation checks for email formats, phone numbers, and other fields.
Technologies Used: 🛠️
Backend: Java, Hibernate (ORM), JPA
Database: MySQL (configured via Hibernate property files)
Security: BCrypt for password encryption
Design Patterns: Façade, Factory
