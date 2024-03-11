import com.google.gson.Gson;
import model.Claim;
import model.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private List<Claim> claims;
    private List<Customer> customers;

    public Manager() {
        try {
            Gson gson = new Gson();
            File file = new File("db/claim.txt");
            Scanner myReader = new Scanner(file);
            claims = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                claims.add(gson.fromJson(data, Claim.class));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Claim claim) {
        claims.add(claim);
    }

    public void delete(Claim claim) {
        claims.remove(claim);
    }

    public void update(Claim claim) {
        if (claims.removeIf(c -> c.getId().equals(claim.getId())))
            claims.add(claim);
    }

    public void printAll() {
        for (Claim claim : claims) {
            System.out.println(claim.toString());
        }
    }

    public void exit() {
        try {
            FileWriter myWriter = new FileWriter("db/claim.txt");
            String data = "";
            for (Claim claim : claims) {
                data = data.concat(claim.toJson());
            }
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
