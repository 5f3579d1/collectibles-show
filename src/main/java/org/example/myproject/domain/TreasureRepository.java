package org.example.myproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by k on 6/6/15.
 */
public interface TreasureRepository extends JpaRepository<Treasure, Long>, JpaSpecificationExecutor {

}
