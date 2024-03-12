import com.google.gson.Gson;
import model.Claim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ClaimRepository implements ClaimProcessManager {

    private final List<Claim> claims;

    public ClaimRepository() {
        try {
            Gson gson = new Gson();
            File file = new File("db/claim.json");
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

    @Override
    public void add(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void update(Claim claim) {
        claims.removeIf(c -> c.getId().equals(claim.getId()));
        claims.add(claim);
    }

    @Override
    public void delete(Claim claim) {
        claims.remove(claim);
    }

    @Override
    public List<Claim> getAll() {
        return claims;
    }

    @Override
    public Claim getOne(UUID id) {
        for (Claim claim : claims) {
            if (claim.getId().equals(id))
                return claim;
        }
        return null;
    }

    public void save() {
        try {
            FileWriter myWriter = new FileWriter("db/claim.json");
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
