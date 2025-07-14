package com.jongkeun.movie_review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private String reviewer;

    @NotNull(message = "평점을 입력하세요")
    @Min(value = 1, message = "평점은 1~5점 사이로 입력해주세요")
    @Max(value = 5, message = "평점은 1~5점 사이로 입력해주세요")
    private Integer rating;

    @NotBlank(message = "댓글을 입력하세요")
    private String comment;
}
