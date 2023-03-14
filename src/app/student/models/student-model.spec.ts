import { StudentModel } from './student-model';

describe('StudentModel', () => {
  it('should create an instance', () => {
    expect(new StudentModel()).toBeTruthy();
  });


  it (`should have 'Aubert as lastName`, () =>{
    const student : StudentModel = new StudentModel()
    //fill student object
    student.lastName = 'Aubert'
    student.email = 'jean-luc.aubert@aelion.fr'
    student.login = 'jl'
    student.password ='123456'

    expect(student.lastName).toBe('Aubert')
  })
});
