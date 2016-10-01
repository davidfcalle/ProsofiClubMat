import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';


import { routing } from './app.routing';


import { AppComponent }  from './app.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component'
import { InstitutionListComponent } from './institution/institution.component'
import { InstitutionCreateComponent } from './institution/institution.create.component'
import { InstitutionEditComponent } from './institution/institution.edit.component'

import { UserService } from './services/user.service';
import { InstitutionService } from './services/institution.service';

import { SignupGuard } from './guards/signup.guard'; 

@NgModule({
  imports: [ 
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [ 
    AppComponent,
    SignupComponent,
    SigninComponent,
    InstitutionListComponent,
    InstitutionCreateComponent,
    InstitutionEditComponent
  ],
  providers:[
    UserService,
    InstitutionService,
    SignupGuard
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {   }
