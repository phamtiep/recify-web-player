package com.swe.recify.repository;

import com.swe.recify.model.ViewManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ViewManagerRepository extends JpaRepository<ViewManager, Long> {
        ViewManager findViewManagerByUserIdAndMusicId(long userID, long musicID);

}
