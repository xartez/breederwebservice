import {Component, OnInit} from '@angular/core';
import {Owner} from "./interfaces/owner";
import {Dog} from "./interfaces/dog";
import {Reservation} from "./interfaces/reservation";
import {MedicalExam} from "./interfaces/medicalExam";
import {Training} from "./interfaces/training";
import {Litter} from "./interfaces/litter";
import {OwnerService} from "./services/owner.service";
import {HttpErrorResponse} from "@angular/common/http";
import { NgForm } from '@angular/forms';
import { FormsModule }   from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angularclient';
  public owners: Owner[];
  public editOwner: Owner;
  public deleteOwner: Owner;
  public dogs: Dog[];
  public reservations: Reservation[];
  public medicalExams: MedicalExam[];
  public trainings: Training[];
  public litters: Litter[];

  constructor(private ownerService: OwnerService) {

  }

  ngOnInit() {
    this.getOwners();
  }

  public getOwners() : void {
    this.ownerService.getOwners().subscribe(
      (response:Owner[]) => {
        this.owners = response;
        console.log(this.owners);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddOwner(addForm: NgForm): void {
    // @ts-ignore: Object is possibly 'null'.
    document.getElementById('add-owner-form').click();
    this.ownerService.addOwner(addForm.value).subscribe(
      (response: Owner) => {
        console.log(response);
        this.getOwners();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateOwner(owner: Owner): void {
    this.ownerService.updateOwner(owner).subscribe(
      (response: Owner) => {
        console.log(response);
        this.getOwners();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteOwner(ownerId: string): void {
    this.ownerService.deleteOwner(ownerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getOwners();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchOwners(key: string): void {
    console.log(key);
    const results: Owner[] = [];
    for (const owner of this.owners) {
      if (owner.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || owner.lastName.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || owner.phoneNumber.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || owner.kennel.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(owner);
      }
    }
    this.owners = results;
    if (results.length === 0 || !key) {
      this.getOwners();
    }
  }

  public onOpenModal(owner: Owner, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addOwnerModal');
    }
    if (mode === 'edit') {
      this.editOwner= owner;
      button.setAttribute('data-target', '#updateOwnerModal');
    }
    if (mode === 'delete') {
      this.deleteOwner = owner;
      button.setAttribute('data-target', '#deleteOwnerModal');
    }
    // @ts-ignore: Object is possibly 'null'.
    container.appendChild(button);
    button.click();
  }

}
