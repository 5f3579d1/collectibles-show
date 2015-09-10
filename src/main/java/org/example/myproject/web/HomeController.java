package org.example.myproject.web;

import org.example.myproject.domain.Scene;
import org.example.myproject.domain.Treasure;
import org.example.myproject.service.SceneService;
import org.example.myproject.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private TreasureService treasureService;

    @Autowired
    private SceneService sceneService;

    @RequestMapping("")
    public
    @ResponseBody
    List<Treasure> index() {
        return sceneService.findLast().getTreasures();
    }

    @RequestMapping(value = "/scene", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Scene> scene() {
        return sceneService.findAll();
    }

    @RequestMapping(value = "/scene", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addScene() {
        return sceneService.create();
    }

    @RequestMapping(value = "/treasure", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addTreasure(Treasure treasure) {
        return treasureService.create(treasure);
    }

    @RequestMapping(value = "/treasure/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean modifyTreasure(Treasure treasure) {
        return treasureService.update(treasure);
    }

}
