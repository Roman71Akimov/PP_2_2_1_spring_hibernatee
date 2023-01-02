package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user = new User("User1", "Lastname1", "user1@mail.ru");
      user.setUserCar(new Car("VAZ", 1));
      userService.add(user);


      user = new User("User2", "Lastname2", "user2@mail.ru");
      user.setUserCar(new Car("VAZ", 2));
      userService.add(user);

      user = new User("User3", "Lastname3", "user3@mail.ru");
      user.setUserCar(new Car("VAZ", 3));
      userService.add(user);


      user = new User("User4", "Lastname4", "user4@mail.ru");
      user.setUserCar(new Car("VAZ", 4));
      userService.add(user);


      List<User> users = userService.listUsers();
      for (User user1 : users) {
         System.out.println("Id = "+user1.getId());
         System.out.println("First Name = "+user1.getFirstName());
         System.out.println("Last Name = "+user1.getLastName());
         System.out.println("Email = "+user1.getEmail());
         System.out.println("Car = "+user1.getUserCar());
      }
      User user2 = userService.getUserByCar("VAZ", 2);
      System.out.println(user2);
      context.close();
   }
}
