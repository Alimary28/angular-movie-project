import { Component, OnInit } from '@angular/core';
import {Movie} from '../shared/movie.model';
import {MovieService} from '../shared/movie.service';
import {Router} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-movie-list',
  moduleId: module.id,
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  errorMessage: string;
  movies: Array<Movie>;
  selectedMovie: Movie;
  constructor(private movieService: MovieService,
              private location: Location,
              private router: Router) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies() {
    this.movieService.getMovies()
      .subscribe(
        movies => this.movies = movies,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }

  gotoDetail(): void {
    this.router.navigate(['/movie/detail', this.selectedMovie.id]);
  }

  delete(movie: Movie) {
    this.movieService.delete(movie.id)
      .subscribe(_=> {
        console.log("Movie deleted");
        this.movies = this.movies.filter(m => m.id !== movie.id);
      });
  }

}
