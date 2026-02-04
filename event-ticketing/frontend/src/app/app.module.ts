import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

@NgModule({
  imports: [
    BrowserModule,
    AppComponent   // <-- import the standalone component here
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
