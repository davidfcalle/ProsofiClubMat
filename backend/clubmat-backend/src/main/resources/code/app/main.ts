import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { enableProdMode } from '@angular/core';

import { AppModule } from './app.module';

import "angular2-materialize";

enableProdMode();
platformBrowserDynamic().bootstrapModule(AppModule);
