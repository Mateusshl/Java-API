package com.company.healthtest.task.facade;


import com.company.healthtest.task.dto.TaskDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class TaskFacade {
    private static  final Map<Long, TaskDTO> task = new HashMap<>();

// Creating a register


    public TaskDTO create(TaskDTO taskDTO){
        long nextId = task.keySet().size() + 1L;
        taskDTO.setId(nextId);
        task.put(nextId, taskDTO);
        return  taskDTO;
    }

    // Updating a register
    public TaskDTO uptade(TaskDTO taskDTO, Long taskId){
        task.put(taskId, taskDTO);
        return  taskDTO;
    }
    // Return by ID
    public TaskDTO returnById(long taskId ){
        return task.get(taskId);
    }

    // Return id by list (all id);

    public List<TaskDTO>getAll(){
        return  new ArrayList<>(task.values());
    }
    //DELETE

    public String delete (Long taskId){
        task.remove(taskId);
        return "DELETED";
    }
}
