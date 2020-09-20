package com.devsuperior.dspesquisa.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dspesquisa.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query("select r from Record r where "
			+ "(coalesce(:minDate, null) IS NULL OR r.moment >= :minDate) and "
			+ "(coalesce(:maxDate, null) IS NULL OR r.moment <= :maxDate)")
	Page<Record> findByMomentd(@RequestParam(value = "minDate") Instant minDate, @RequestParam(value = "maxDate") Instant maxDate, Pageable pageRequest);
}
