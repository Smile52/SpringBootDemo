package com.smile.repository;

import com.smile.domain.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 分页排序
 */
public interface GirlPageRepository extends PagingAndSortingRepository<Girl, Integer> {

}
