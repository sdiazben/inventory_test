import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { inventoryComponent } from './user-list/inventory.component';

const routes: Routes = [
  { path: 'inventory', component: inventoryComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
