import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Client} from './client.model';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import {Movie} from '../../movies/shared/movie.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private clientUrl = 'http://localhost:8080/api/clients';

  constructor(private httpClient: HttpClient) { }
  getClients(): Observable<Client[]> {
    return this.httpClient
      .get<Array<Client>>(this.clientUrl);
  }

  getClient(id: number): Observable<Client> {
    return this.getClients()
      .pipe(map(clients => clients.find(client => client.id === id)));
  }

  update(client): Observable<Client> {
    const url = `${this.clientUrl}/${client.id}`;
    return this.httpClient.put<Client>(url, client);
  }
  /** POST: add a new client to the server */
  save(client: Client): Observable<Client> {
    console.log(client);
    return this.httpClient.post<Client>(this.clientUrl, client);
  }
  delete(id: number): Observable<any> {
    const url = `${this.clientUrl}/${id}`;
    console.log("delete url: ", url);
    return this.httpClient.delete(url);
  }

}
