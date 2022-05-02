package com.tenunft.api.repository;

import com.tenunft.api.model.entity.NonFungibleTokenModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public interface NonFungibleTokenRepo extends JpaRepository<NonFungibleTokenModel, Long> {
    Page<NonFungibleTokenModel> findByEnabledTrue(Pageable pageable);

    List<NonFungibleTokenModel> findAllByEnabledTrue();

    Long countByEnabledTrue();
}
