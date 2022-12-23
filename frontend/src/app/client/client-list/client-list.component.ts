import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ClientsService } from '../../clients.service';
import { Client } from '../client';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  clients: Client[] = [];
  selectedClient: Client;
  successMessage: string;
  errorMessage: string;

  constructor(private service: ClientsService, 
    private router: Router){ }

  ngOnInit(): void {
    this.service
    .getClient()
    .subscribe(response => this.clients = response);
  }

  newRegister(){
    this.router.navigate(['/client/form'])
  }

  prepareForDeletion(client: Client){
    this.selectedClient = client;
  }

  deleteClient(){
    this.service.delete(this.selectedClient)
    .subscribe(
      response => {this.successMessage = 'Client deleted successfully',
    this.ngOnInit();},
    error => this.errorMessage = 'An error occurred while deleting client register')
  }
}
