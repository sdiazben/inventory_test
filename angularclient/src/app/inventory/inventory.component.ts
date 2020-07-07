import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { InventoryService } from '../service/inventory.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  inventory: Observable<Item[]>;
  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
     console.log("hol");
     this.inventory = this.inventoryService.getInventory();
   }
}

