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
import { OlympiadsResultComponent } from './olympiads/olympiad.results.component';


import { SignupGuard } from './guards/signup.guard';
import { AdminGuard } from './guards/admin.guard';
 

const appRoutes: Routes = [
  {
    path: 'signup',
    component: SignupComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'signin',
    component: SigninComponent
  },
  {
    path: 'instituciones',
    component: InstitutionListComponent,
    canActivate:  [SignupGuard]
  },
   {
    path: 'instituciones/crear',
    component: InstitutionCreateComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'instituciones/:id/editar',
    component: InstitutionEditComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'clubes',
    component: InstitutionListComponent,
    canActivate:  [SignupGuard]
  },
  {
    path: 'preguntas',
    component: QuestionsComponent,
    canActivate:  [SignupGuard]
  },
  {
    path: 'preguntas/crear',
    component: QuestionCreateComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'preguntas/:id/editar',
    component: QuestionEditComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'usuarios',
    component: UserListComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'usuarios/:id/editar',
    component: UserEditComponent,
    canActivate:  [SignupGuard]
  },
  {
      path : 'pruebas',
      component: TestComponent,
      canActivate:  [SignupGuard]
  },
   {
      path : 'pruebas/:tipo/crear',
      component: TestCreateComponent,
      canActivate:  [SignupGuard]
   },
   {
      path : 'pruebas/:id/tomar',
      component: TakeTestComponent,
      canActivate:  [SignupGuard]
   },
   {
    path: 'olimpiadas',
    component: OlympiadsComponent,
    canActivate:  [SignupGuard]
  },
  {
    path: 'olimpiadas/crear',
    component: OlympiadCreateComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'olimpiadas/:id/detalle',
    component: OlympiadDetailComponent,
    canActivate:  [SignupGuard]
  },
  {
    path: 'olimpiadas/:id/editar',
    component: OlympiadEditComponent,
    canActivate:  [AdminGuard]
  },
  {
    path: 'olimpiadas/:id/resultados',
    component: OlympiadsResultComponent,
    canActivate: [SignupGuard]
  },
  {
    path: '',
    redirectTo: '/pruebas',
    pathMatch: 'full'
  },

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
