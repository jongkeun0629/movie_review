package com.jongkeun.movie_review.repository;

import com.jongkeun.movie_review.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // List<Review>의 경우 리뷰의 데이터 전부 호출. 조회마다 전부 가져오지 않고 필요한 데이터만 호출하는 Page
    // Pageable pageable: 어디서부터 어디까지 어떻게 정렬
    Page<Review> findByMovieId(Long movieId, Pageable pageable);
}
