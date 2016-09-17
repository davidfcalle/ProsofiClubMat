import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';

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
    path: '',
    redirectTo: '/signup',
    pathMatch: 'full'
  },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);