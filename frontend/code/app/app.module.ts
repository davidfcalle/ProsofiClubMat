import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';


import { routing } from './app.routing';


import { AppComponent }  from './app.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component'

import { UserService } from './services/user.service';

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
  ],
  providers:[
    UserService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {   }
