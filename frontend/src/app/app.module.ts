import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component'
import { ClientModule } from './client/client.module';
import { ClientsService } from './clients.service';
import { ServiceProvidedModule } from './service-provided/service-provided.module';
import { ServiceProvidedService } from './service-provided.service';
import { LoginComponent } from './login/login.component';
import { LayoutComponent } from './layout/layout.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    LayoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ClientModule,
    TemplateModule,
    ServiceProvidedModule 
  ],
  providers: [
    ClientsService,
    ServiceProvidedService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
