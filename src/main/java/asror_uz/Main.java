package asror_uz;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1.Car
                    2.Student
                    """);
            int item = scannerInt.nextInt();
            switch (item) {
                case 1 -> {
                    while (true) {
                        System.out.println("""
                                1.Create
                                2.Read
                                3.Update
                                4.Delete
                                """);
                        int tanlash = scannerInt.nextInt();
                        switch (tanlash) {
                            case 1 -> {
                                System.out.println("Enter id : ");
                                Long userid = scannerInt.nextLong();

                                System.out.println("Enter name : ");
                                String name = scannerString.nextLine();

                                System.out.println("Enter color : ");
                                String color = scannerString.nextLine();

                                System.out.println("Enter price : ");
                                double price = scannerInt.nextDouble();

                                Car car = new Car(userid, name, color, price);
                                Database database = new Database();
                                database.createCar(car);
                            }
//                Read
                            case 2 -> {
                                Database database = new Database();
                                database.readCar();
                            }

//                Update

                            case 3 -> {
                                System.out.println("Qaysi idni yangilaysiz?");
                                long id = scannerInt.nextLong();

                                System.out.println("yangi name :");
                                String name = scannerString.nextLine();

                                System.out.println("Yangi color :");
                                String color = scannerString.nextLine();

                                System.out.println("Yangi price :");
                                double price = scannerInt.nextDouble();

                                Car car = new Car(id, name, color, price);
                                Database database = new Database();
                                database.updateCar(car);
                            }

//                Delete

                            case 4 -> {
                                System.out.println("Qaysi idni o'chirasiz");
                                long id = scannerInt.nextLong();

                                Database database = new Database();
                                database.deleteCar(id);
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1.Create Student
                            2.Read Student
                            3.Update Student
                            4.Delete Student
                            """);

                    int student = scannerInt.nextInt();
                    switch (student){
                        case 1 ->{
                            System.out.println(" Enter id :");
                            long id = scannerInt.nextLong();

                            System.out.println(" Enter name :");
                            String name = scannerString.nextLine();

                            System.out.println(" Enter surname :");
                            String surname = scannerString.nextLine();

                            System.out.println(" Enter age :");
                            int age = scannerInt.nextInt();

                            Student student1 = new Student(id , name , surname , age);
                            StudentDatabase studentDatabase = new StudentDatabase();
                            studentDatabase.studentCrete(student1);
                        }
                        case 2 ->{
                            StudentDatabase studentDatabase = new StudentDatabase();
                            studentDatabase.studentRead();
                        }
//                        case 3 ->{
//                            System.out.println("Qaysin idni yangilaysiz?");
//                            long id = scannerInt.nextLong();
//
//                            System.out.println("yangi name :");
//                            String name = scannerString.nextLine();
//
//
//                            System.out.println("Yangi surname");
//                            String surname = scannerString.nextLine();
//
//                            System.out.println("yangi age");
//                            int age = scannerInt.nextInt();
//
//                            Student student1 = new Student(id , name , surname , age);
//                            StudentDatabase studentDatabase = new StudentDatabase();
//                            studentDatabase.
//                        }
                    }
                }
            }
        }
    }
}