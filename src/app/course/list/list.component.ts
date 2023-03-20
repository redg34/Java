import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';
import { SelectCourseType } from '../types/select-course-type';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  public courses: Array<any>=[]

  errorMessage!: string;

  constructor(
    private _courseService: CourseService
  ) { }

  ngOnInit(): void {
    this.getCoursesAll();
  }
  getCoursesAll() {
      this._courseService.findAll().subscribe({
        next: (data) => {
         //console.log(`Got ${data.length}`)
          this.courses = data;
        },
        error: (err) => {
          this.errorMessage = err;
        }
      });

  }

  showHide(course: SelectCourseType): void  {
    course.isSelected = !course.isSelected
  }

}
