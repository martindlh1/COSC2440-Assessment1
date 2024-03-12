import model.Claim;
import java.util.List;
import java.util.UUID;

public interface ClaimProcessManager {
    void add(Claim claim);

    void update(Claim claim);

    void delete(Claim claim);

    List<Claim> getAll();

    Claim getOne(UUID id);
}
