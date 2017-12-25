package jdev.tracker.dao.repo;

import jdev.tracker.dao.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRepository extends CrudRepository<Point, Integer> {
}
