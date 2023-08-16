package ProjectManager.repositories;

import org.springframework.data.repository.CrudRepository;

import ProjectManager.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}