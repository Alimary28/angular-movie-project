import { Component, OnInit } from '@angular/core';
import {MovieService} from './shared/movie.service';
import {Router} from '@angular/router';


@Component({
  moduleId: module.id,
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent {
  clicked: boolean;
  constructor(private movieService: MovieService,
              private router: Router) { }
  goBack() {
    this.clicked = false;
    this.reload();
  }

  save(title, category, year, price) {
    const id = 0;
    this.movieService.save({
      id, title, category, year, price
    }).subscribe(movie => {
      this.clicked = false;
      this.reload();
    },
      error => console.log("Error in saving movie: ", error),
      () => console.log("completed"));

  }

  addMovie() {
    this.clicked = true;
  }
  private reload() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/movies']);
    });
}
}
