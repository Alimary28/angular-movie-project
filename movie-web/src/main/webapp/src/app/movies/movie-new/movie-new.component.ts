import { Component, OnInit } from '@angular/core';
import {MovieService} from '../shared/movie.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css']
})
export class MovieNewComponent implements OnInit {

  constructor(private movieService: MovieService, private location: Location) { }

  ngOnInit() {
  }

  goBack() {
    this.location.back();
  }

  save(title, category, year, price) {
    const id = 0;
    this.movieService.save({
      id, title, category, year, price
    }).subscribe(movie => this.location.back(),
      error => console.log("Error in saving movie: ", error),
      () => console.log("completed"));

  }
}
