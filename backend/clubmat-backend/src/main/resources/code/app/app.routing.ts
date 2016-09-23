import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { InstitutionListComponent} from './institution/institution.component'
import { InstitutionCreateComponent} from './institution/institution.create.component'
import { InstitutionEditComponent} from './institution/institution.edit.component'
 

const appRoutes: Routes = [
  {
    path: 'signup',
    component: SignupComponent
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
    path: '',
    redirectTo: '/signup',
    pathMatch: 'full'
  },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);