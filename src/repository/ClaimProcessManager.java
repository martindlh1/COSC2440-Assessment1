package repository;

import model.Claim;
import java.util.List;

public interface ClaimProcessManager {
    void add(Claim claim);

    void update(Claim claim);

    boolean delete(Claim claim);

    List<Claim> getAll();

    Claim getOne(Number id);
}
