import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MoviesComponent} from './movies/movies.component';
import {MovieDetailComponent} from './movies/movie-detail/movie-detail.component';
import {ClientsComponent} from './clients/clients.component';
import {ClientDetailComponent} from './clients/client-detail/client-detail.component';
import {ClientNewComponent} from './clients/client-new/client-new.component';



const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'movies', component: MoviesComponent},
  {path: 'movie/detail/:id', component: MovieDetailComponent},
  {path: 'clients', component: ClientsComponent},
  {path: 'client/detail/:id', component: ClientDetailComponent},
  {path: 'client-new', component: ClientNewComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
