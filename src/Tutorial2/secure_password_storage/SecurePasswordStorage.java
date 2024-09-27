package Tutorial2.secure_password_storage;

import java.io.*;
import java.util.Scanner;

public class SecurePasswordStorage {
    private static final String FILE_NAME = "src/Tutorial2/secure_password_storage/acc.ser";

    private static void serializeUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(user);
            System.out.println("User serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User deserializeUser() {
        User deserializedUser = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            deserializedUser = (User) ois.readObject();
            System.out.println("User deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedUser;
    }

    private static void verifyUser(String inputUsername, String inputPassword) {
        // Check if the username matches
        User deserializedUser = deserializeUser();
        if (deserializedUser == null) {
            System.out.println("Error deserializing user.");
            return;
        }

        if (inputUsername.equals(deserializedUser.getUsername())) {
            // Verify the password
            if (deserializedUser.verifyPassword(inputPassword)) {
                System.out.println("Password verification successful.");
            } else {
                System.out.println("Password verification failed.");
            }
        } else {
            System.out.println("Username does not match.");
        }
    }

    public static void main(String[] args) {
        // Create a new user and serialize it
        User user = new User("user", "password");
        serializeUser(user);

        // TODO: input username/password => check password by comparing the hashed version of a user-provided password with the stored hash
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        verifyUser(inputUsername, inputPassword);

    }
}
