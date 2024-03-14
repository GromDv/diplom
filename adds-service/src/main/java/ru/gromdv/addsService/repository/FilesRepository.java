package ru.gromdv.addsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gromdv.addsService.model.FileInStorage;

import java.util.List;


@Repository
public interface FilesRepository extends JpaRepository<FileInStorage, Long> {
    List<FileInStorage> findAllByTaskId(Long taskId);
}
