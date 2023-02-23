package com.timg.inventorysys;


import org.springframework.data.jpa.repository.JpaRepository;

public interface item_repo
        extends JpaRepository<item, Integer> {
}
