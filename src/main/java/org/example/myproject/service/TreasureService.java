package org.example.myproject.service;

import org.example.myproject.domain.Treasure;
import org.example.myproject.domain.TreasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Created by k on 6/6/15.
 */
@Service
@Transactional(readOnly = true)
public class TreasureService {

    @Autowired
    private TreasureRepository repository;

    @Transactional
    public boolean create(Treasure treasure) {
        try {
            repository.saveAndFlush(treasure);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public boolean update(Treasure treasure) {
        try {

            Long id = treasure.getId();
            if (id != null) {

                Treasure one = repository.findOne(id);

                if (!StringUtils.isEmpty(treasure.getName()))
                    one.setName(treasure.getName());

                if (!StringUtils.isEmpty(treasure.getDimension()))
                    one.setDimension(treasure.getDimension());

                if (!StringUtils.isEmpty(treasure.getRemark()))
                    one.setRemark(treasure.getRemark());

                if (!CollectionUtils.isEmpty(treasure.getImages())) {
                    one.getImages().clear();
                    one.setImages(treasure.getImages());
                }

                repository.saveAndFlush(one);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
