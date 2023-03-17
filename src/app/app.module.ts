import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TileComponent } from './dashboard/components/tile/tile.component';
import { StudentModule } from './student/student.module';
import { CommonModule } from '@angular/common';
import { SharedModule } from './shared/shared.module';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TileComponent,

  ],
  imports: [
    CommonModule,
    BrowserModule,
    StudentModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
