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
    path: 'usuarios',
    component: UserListComponent
  },
  {
    path: 'usuarios/:id/editar',
    component: UserEditComponent
  },
  {
    path: '',
    redirectTo: '/signup',
    pathMatch: 'full'
  },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);