package com.company.healthtest.task.api;
import com.company.healthtest.task.dto.TaskDTO;
import com.company.healthtest.task.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/task",produces = MediaType.APPLICATION_JSON_VALUE )
public class TaskAPI {
    @Autowired
    private TaskFacade taskFacade;


    @PostMapping
    @ResponseBody
    public TaskDTO create(@RequestBody TaskDTO taskDTO) {
       return taskFacade.create(taskDTO);
    }

    @PutMapping("/taskId")
    @ResponseBody
    public TaskDTO update (@PathVariable("taskId")Long taslId, @RequestBody TaskDTO taskDTO){
        return taskFacade.uptade(taskDTO, taslId);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO>getAll(){
        return taskFacade.getAll();
    }

    @DeleteMapping("/taskId")
    @ResponseBody
    public String  delete(@PathVariable("takId") Long TaskId){
        return taskFacade.delete(TaskId);
    }
}
