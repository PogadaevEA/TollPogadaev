package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.dao.Point;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by Егор on 19.11.2017.
 */
@Service
public class DataPeekService {

    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);

    @Autowired
    CrudService crudService;

    public BlockingDeque<PointDTO> getQueue() {
        return queue;
    }

    PointDTO take() throws InterruptedException{
        return queue.take();
    }

    void put(PointDTO newpoint) throws InterruptedException {
        queue.put(newpoint);
    }

    public void  putDB(Point point){
        crudService.create(point);
    }

    public List<Point> getPointsDB(){
        return  crudService.read();
    }
}
