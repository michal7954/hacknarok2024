package org.example.backend.repository;

import org.example.backend.db.PostStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostStatisticRepository extends CrudRepository<PostStatistic, Long> {
}
