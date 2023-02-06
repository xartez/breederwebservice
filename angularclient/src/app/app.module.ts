import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {OwnerService} from "./services/owner.service";
import {DogService} from "./services/dog.service";
import {LitterService} from "./services/litter.service";
import {TitleService} from "./services/title.service";
import {ReservationService} from "./services/reservation.service";
import {TrainingService} from "./services/training.service";
import {MedicalExamService} from "./services/medicalExam.service";
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [OwnerService, DogService, LitterService, TitleService, ReservationService, TrainingService, MedicalExamService],
  bootstrap: [AppComponent]
})
export class AppModule { }
