package org.example.myproject.service;

import org.example.BaseTest;
import org.example.myproject.domain.TreasureRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by k on 9/10/15.
 */
public class SceneServiceTest extends BaseTest {

    @Autowired
    private SceneService service;

    @Test
    public void test() throws Exception {
        System.err.println("create: " + service.create());
        System.err.println("find all: " + service.findAll());
        System.err.println("find last: " + service.findLast());
    }

}