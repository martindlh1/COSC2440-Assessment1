/**
 * @author <Martin Delahousse - s4034308>
 */

package repository;

import java.util.List;

public interface ProcessManager<T> {
    void add(T t);

    void update(T t);

    boolean delete(T t);

    List<T> getAll();

    T getOne(Number id);

    void save();
}
