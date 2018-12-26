package com.kkwrite.demo.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kkwrite.demo.product.pojo.GoodsDO;

public interface GoodsRepository extends JpaRepository<GoodsDO, Long> {
    
    GoodsDO findByGoodsId(Long goodsId);
    
    @Query(value = "select count(*) from goods", nativeQuery=true)
	int getGoodsCount();
    
}
