import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PunctuationCountComponent } from './pages/punctuation-count/punctuation-count.component';


const routes: Routes = [
  { path: '', component: PunctuationCountComponent },
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
