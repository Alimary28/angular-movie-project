import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {ClientService} from '../shared/client.service';

@Component({
  selector: 'app-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {

  constructor(private clientService: ClientService, private location: Location) { }

  ngOnInit() {
  }

  goBackToClients() {
    this.location.back();
  }

  saveClient(cnp, firstName, lastName, age) {
    const id = 0;
    this.clientService.save({
      id, cnp, firstName, lastName, age
    }).subscribe(client => this.location.back(),
      error => console.log("Error in saving client: ", error),
      () => console.log("completed"));

  }
}
