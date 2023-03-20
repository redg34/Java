import { Pipe, PipeTransform } from '@angular/core';
import { IStudent } from '../interfaces/i-student';
import { StudentModel } from '../models/student-model';

@Pipe({
  name: 'initials'
})
export class InitialsPipe implements PipeTransform {

  transform(value: IStudent, ...args: unknown[]): unknown {
    if(args [0] ==='lastNameFirst') {
      return value.lastName!.charAt(0) + value.lastName.charAt(0);
    }
    return value.firstName!.charAt(0) + value.lastName.charAt(0);
  }

}
