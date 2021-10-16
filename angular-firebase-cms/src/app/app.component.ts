import { Component, OnDestroy } from '@angular/core';
import { AngularFireDatabase} from 'angularfire2/database';
//import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

 //  FirebaseListObservable(<any[]>) ;
 courses$;
 
  course$;

  author$;
  // courses:any[];
   //subscription:Subscription;

  constructor(db: AngularFireDatabase){

    this.courses$=db.list('/courses').valueChanges();
    console.log(this.courses$);

    this.course$=db.object('/courses/1').valueChanges();

    this.author$=db.object('/author/1').valueChanges();

    //db.list('/courses');

  //  this.subscription = db.list('/courses').valueChanges()
  //   .subscribe(courses=>{   //error
  //     this.courses=courses;
  //     console.log(this.courses);

  //   });

   }


  //  ngOnDestroy(){

  //  // this.subscription.unsubscribe();
  //   console.log('Destroy');
  //  }

add( course: HTMLInputElement)
{
  this.courses$.push(course);
  course.value='';
}

}
