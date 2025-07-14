package com.jongkeun.movie_review.controller;

import com.jongkeun.movie_review.dto.MovieDto;
import com.jongkeun.movie_review.model.Movie;
import com.jongkeun.movie_review.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    // GetMapping은 RequestBody 대신 Param
    public Page<Movie> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        // 0 ~ 10 내림차순. 최신부터
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        return movieService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable Long id){
        return movieService.getById(id);
    }

    @PostMapping
    public Movie create(@Valid @RequestBody MovieDto movieDto){
        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());

        return movieService.create(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @Valid @RequestBody MovieDto movieDto){
        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());

        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        movieService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
