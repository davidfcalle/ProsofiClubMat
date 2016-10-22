import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';

import { UserListComponent } from './users/users.component';
import { UserEditComponent } from './users/user.edit.component';

import { InstitutionListComponent } from './institution/institution.component';
import { InstitutionCreateComponent } from './institution/institution.create.component';
import { InstitutionEditComponent } from './institution/institution.edit.component';

import { QuestionsComponent } from './question/questions.component';
import { QuestionCreateComponent } from './question/question.create.component';
import { QuestionEditComponent } from './question/question.edit.component';


import { TestComponent } from './tests/tests.component'
import { TestCreateComponent } from './tests/tests.create.component'
import { TakeTestComponent } from './tests/take.tests.component';

import { OlympiadsComponent } from './olympiads/olympiad.component';
import { OlympiadCreateComponent } from './olympiads/olympiad.create.component';
import { OlympiadDetailComponent } from './olympiads/olympiad.detail.component';
import { OlympiadEditComponent } from './olympiads/olympiad.edit.component';


import { SignupGuard } from './guards/signup.guard'; 

const appRoutes: Routes = [
  {
    path: 'signup',
    component: SignupComponent,
    canActivate:  [SignupGuard]
  },
  {
    path: 'signin',
    component: SigninComponent
  },
  {
    path: 'instituciones',
    component: InstitutionListComponent
  },
   {
    path: 'instituciones/crear',
    component: InstitutionCreateComponent
  },
  {
    path: 'instituciones/:id/editar',
    component: InstitutionEditComponent
  },
  {
    path: 'preguntas',
    component: QuestionsComponent
  },
  {
    path: 'preguntas/crear',
    component: QuestionCreateComponent
  },
  {
    path: 'preguntas/:id/editar',
    component: QuestionEditComponent
  },
  {
    path: 'usuarios',
    component: UserListComponent
  },
  {
    path: 'usuarios/:id/editar',
    component: UserEditComponent
  },
  {
      path : 'pruebas',
      component: TestComponent
  },
   {
      path : 'pruebas/:tipo/crear',
      component: TestCreateComponent
   },
   {
      path : 'pruebas/:id/tomar',
      component: TakeTestComponent
   },
   {
    path: 'olimpiadas',
    component: OlympiadsComponent
  },
  {
    path: 'olimpiadas/crear',
    component: OlympiadCreateComponent
  },
  {
    path: 'olimpiadas/:id/detalle',
    component: OlympiadDetailComponent
  },
  {
    path: 'olimpiadas/:id/editar',
    component: OlympiadEditComponent
  },
  {
    path: '',
    redirectTo: '/signup',
    pathMatch: 'full'
  },

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);