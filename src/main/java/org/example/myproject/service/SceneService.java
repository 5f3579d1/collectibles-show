package org.example.myproject.service;

import org.example.myproject.domain.Scene;
import org.example.myproject.domain.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by k on 6/6/15.
 */
@Service
@Transactional(readOnly = true)
public class SceneService {

    @Autowired
    private SceneRepository repository;

    public List<Scene> findAll() {
        return repository.findAll();
    }

    public Scene findLast() {
        return repository.findTop1ByOrderByCreateTimeDesc();
    }

    @Transactional
    public boolean create() {
        Scene scene = new Scene();
        try {
            repository.saveAndFlush(scene);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
