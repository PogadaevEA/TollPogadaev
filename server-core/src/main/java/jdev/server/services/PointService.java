package jdev.server.services;

import jdev.server.dao.Point;
import jdev.server.dao.Role;
import jdev.server.dao.repo.PointRepository;
import jdev.server.dao.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PointService {

    @Autowired
    PointRepository pointRepository;

    public Point create(Point point){
        return pointRepository.save(point);
    }

    public Point update(Point point){
        return pointRepository.save(point);
    }

    public void delete(Point point){
        pointRepository.delete(point);
    }

}
