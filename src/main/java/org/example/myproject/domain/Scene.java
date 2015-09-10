package org.example.myproject.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 9/10/15.
 */
@Entity
public class Scene extends BaseModel {

    @OneToMany(fetch = FetchType.LAZY)
    private List<Treasure> treasures = new ArrayList<>();

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

}
