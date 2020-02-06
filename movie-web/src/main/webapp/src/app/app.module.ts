import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { ClientsComponent } from './clients/clients.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MovieService} from './movies/shared/movie.service';
import {ClientService} from './clients/shared/client.service';
import { MessageComponent } from './message/message.component';
import { ClientDetailComponent } from './clients/client-detail/client-detail.component';
import { ClientNewComponent } from './clients/client-new/client-new.component';
import {MovieNewComponent} from './movies/movie-new/movie-new.component';

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    ClientsComponent,
    ClientListComponent,
    MovieDetailComponent,
    MovieListComponent,
    MovieNewComponent,
    MessageComponent,
    ClientDetailComponent,
    ClientNewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [MovieService, ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
