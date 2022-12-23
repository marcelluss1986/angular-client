import { Component, OnInit } from '@angular/core';
import { Client } from '../../client/client';
import { ClientsService } from '../../clients.service';
import { ServiceProvided } from '../service-provided';
import { ServiceProvidedService } from '../../service-provided.service';

@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[] = [];
  service: ServiceProvided;
  success: boolean = false;
  errors: String[];

  constructor(
    private clientService: ClientsService,
    private serviceProvidedService: ServiceProvidedService
  ) {
    this.service = new ServiceProvided();
  }

  ngOnInit(): void {
    this.clientService
      .getClient()
      .subscribe(response => this.clients = response);
  }

  onSubmit() {
    this.serviceProvidedService
      .save(this.service)
      .subscribe(response => {
        console.log(response);
        this.success = true;
        this.errors = null;
        this.service = new ServiceProvided();
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
        console.log(errorResponse.error.errors);
      })
  }


}
