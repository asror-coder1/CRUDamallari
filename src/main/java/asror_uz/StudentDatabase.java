package asror_uz;

import java.sql.*;

public class StudentDatabase {
    String url = "jdbc:postgresql://localhost:5432/crudamallari";
    String username = "postgres";
    String password = "root";

//    Create

    public void studentCrete(Student student){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query = "insert into student(id , firstname , lastname , age) values ("+
            student.getId() + ",'" + student.getFirstname() + "','" + student.getLastname() + "'," + student.getAge() + ");";

            statement.execute(query);
            System.out.println("Saqlandi!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Read
    public void  studentRead(){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.getResultSet();


            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surnmae = resultSet.getString(3);
                int age = resultSet.getInt(4);


                Student student = new Student(id , name , surnmae , age);
                System.out.println(student);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
