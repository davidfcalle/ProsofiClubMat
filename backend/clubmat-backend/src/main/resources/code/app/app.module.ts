import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';

import {MaterializeDirective} from "angular2-materialize";


import { routing } from './app.routing';


import { AppComponent }  from './app.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';

import { InstitutionListComponent } from './institution/institution.component';
import { InstitutionCreateComponent } from './institution/institution.create.component';
import { InstitutionEditComponent } from './institution/institution.edit.component';

import { QuestionsComponent } from './question/questions.component';
import { QuestionCreateComponent } from './question/question.create.component';
import { QuestionEditComponent } from './question/question.edit.component';

import { UserListComponent } from './users/users.component';
import { UserEditComponent } from './users/user.edit.component';


import { TestComponent } from './tests/tests.component';
import { TestCreateComponent } from './tests/tests.create.component';


import { OlympiadsComponent } from './olympiads/olympiad.component';
import { OlympiadCreateComponent } from './olympiads/olympiad.create.component';
import { OlympiadDetailComponent } from './olympiads/olympiad.detail.component';
import { OlympiadEditComponent } from './olympiads/olympiad.edit.component';


import { UserService } from './services/user.service';
import { InstitutionService } from './services/institution.service';
import { QuestionService } from './services/question.service';
import { OlympiadService } from './services/olympiad.service';
import { TestService } from './services/test.service';

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
    InstitutionEditComponent,
    UserListComponent,
    UserEditComponent,
    QuestionsComponent,
    QuestionCreateComponent,
    QuestionEditComponent,
    TestComponent,
    TestCreateComponent,
    OlympiadsComponent,
    OlympiadCreateComponent,
    OlympiadDetailComponent,
    OlympiadEditComponent,
    MaterializeDirective
  ],
  providers:[
    UserService,
    InstitutionService,
    SignupGuard,
    QuestionService,
    OlympiadService,
    TestService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {  
  
 }
