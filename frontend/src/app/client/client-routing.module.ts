import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientListComponent } from './client-list/client-list.component';

const routes: Routes = [
  {path: 'clients', component: LayoutComponent, children:[
    
  {path: 'form', component: ClientFormComponent},
  {path: 'form/:id', component: ClientFormComponent},
  {path: 'list', component: ClientListComponent},
  {path: '', redirectTo: '/clients/list', pathMatch: 'full'}
  ]}
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule {}
