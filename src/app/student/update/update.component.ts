import { Component, OnInit, inject } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../services/student.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { IStudent } from '../interfaces/i-student';
import { StudentModel } from '../models/student-model';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-update',
  templateUrl: './../add/add.component.html',//add html of addcomponent to update
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  public form: FormGroup = new FormGroup({})
  public student: StudentModel | null = null

  constructor(
    private _route: ActivatedRoute,
    private _service: StudentService,
    private _formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    console.log(this._route.snapshot.paramMap.get('id'))
    const id: number = +this._route.snapshot.paramMap.get('id')!
    this._service.findOne(id)
      .subscribe({
        next: (student: StudentModel) => {
          this.student = student
          this._builForm()
        },
        error: (error: any) => {
          console.log('something went wrong')
        }
      })
  }
  get c(): { [key: string]: AbstractControl } {
    return this.form.controls
  }
  onSubmit(): void {
    this.student!.lastName = this.c['lastName'].value
    this.student!.firstName = this.c['firstName'].value
    this.student!.email = this.c['email'].value
    this.student!.phoneNumber = this.c['phoneNumber'].value
    this.student!.login = this.c['login'].value
    this.student!.password = this.c['password'].value

    this._service.update(this.student!)
    .subscribe({
      next: (response: HttpResponse<any>) => {
        console.log(JSON.stringify(response))
      },
      error: (error:any) =>{
        console.log(JSON.stringify(error))
      }
    })
  }

  private _builForm(): void {
    this.form = this._formBuilder.group({

      lastName: [
        this.student!.lastName, // Default value
        [
          Validators.required
        ] // Validators function to add to this field
      ],

      email: [
        this.student!.email,
        [
          Validators.required,
          Validators.pattern(/[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/)
        ]
      ],

      firstName: [
        this.student!.firstName
      ],

      phoneNumber: [
        this.student!.phoneNumber
      ],

      login: [
        this.student!.login,
        [
          Validators.required,
          Validators.minLength(8)
        ]
      ],

      password: [
        this.student!.password,
        [
          Validators.required,
          Validators.minLength(8),
          Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/)
        ]
      ]
    })
  }
}
