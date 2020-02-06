import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ClientService} from './shared/client.service';

@Component({
  moduleId: module.id,
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent {
  clicked: boolean;
  constructor(private clientService: ClientService,
              private router: Router) { }
  goBack() {
    this.clicked = false;
    this.reload();
  }

  save(cnp, firstName, lastName, age) {
    const id = 0;
    this.clientService.save({
      id, cnp, firstName, lastName, age
    }).subscribe(client => {
        this.clicked = false;
        this.reload();
      },
      error => console.log("Error in saving clients: ", error),
      () => console.log("completed"));

  }

  addClient() {
    this.clicked = true;
  }
  private reload() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/clients']);
    });
  }

}
