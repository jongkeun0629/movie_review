package com.jongkeun.movie_review.repository;

import com.jongkeun.movie_review.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
