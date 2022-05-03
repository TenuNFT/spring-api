package com.tenunft.api.repository;

import com.tenunft.api.model.entity.FileItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Repository
public interface FileItemRepo extends JpaRepository<FileItemModel, Long> {
    Page<FileItemModel> findByEnabledTrue(Pageable pageable);

    List<FileItemModel> findAllByEnabledTrue();

    Long countByEnabledTrue();
}
