package asror_uz;

import java.sql.*;

public class Database {

    String url = "jdbc:postgresql://localhost:5432/crudamallari";
    String username = "postgres";
    String password = "root";

//    CRUD - > ammallari

//    Create
    public void createCar(Car car){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query = "insert into car(id , name , color , price) values ("
                    +car.getId() + ",'" + car.getName() + "','" + car.getColor() + "'," + car.getPrice() +");";
            statement.execute(query);
            System.out.println("Saqlandi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Read

//     private Long id;
//    private String  name;
//    private String color;
//    private double price;

    public void readCar(){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query = "select * from car";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long carid = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String color = resultSet.getString(3);
                double price = resultSet.getDouble(4);

                Car car = new Car(carid , name , color , price);
                System.out.println(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    Update

    public void updateCar(Car car){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query =
                    "update car set " +
                    "name='" + car.getName() + "', " +
                    "color='"+ car.getColor() + "', " +
                    "price=" + car.getPrice()+
                    " where id=" + car.getId();

            statement.execute(query);
            System.out.println("Update bo'ldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Faqat nameni update qilish

    public void nmaeUpdate(Long id , String name){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query = "update car set name='" + name + "'where id=" + id;

            statement.execute(query);
            System.out.println("Name update boldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    Delete

    public void deleteCar(Long id){
        try {
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();

            String query = "delete from car where id=" + id;
            statement.execute(query);
            System.out.println("Deleted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
