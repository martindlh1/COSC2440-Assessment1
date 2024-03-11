import com.google.gson.Gson;
import model.Claim;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public interface ClaimProcessManager {


    void add();

    void update(Claim claim);

    void delete();

    static List<Claim> getAll() {
        try {
            Gson gson = new Gson();
            File file = new File("db/claim.txt");
            Scanner myReader = new Scanner(file);
            List<Claim> claims = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                claims.add(gson.fromJson(data, Claim.class));
            }
            return claims;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
