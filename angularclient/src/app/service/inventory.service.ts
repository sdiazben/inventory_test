import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../model/item';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

	private invUrl: string;

  constructor(private http: HttpClient) {
  		this.invUrl = 'http://localhost:8080/item';
  }

  public getInventory() : Observable<Item[]> {
    console.log(this.http.get<Item[]>(this.invUrl));
   return this.http.get<Item[]>(this.invUrl);
  }

  //public findItemBySKU(sku: number): Observable<Item> {
   // return this.http.get<Item>(this.invUrl+"/"+1);
  //}

  public addItem (item: Item)
  {
    return this.http.post<Item>(this.invUrl, item);
  }

  //public deleteItem (sku: number)
  //{
    //return this.http.delete<Item>(this.invUrl, sku);
  //}

  //public updateItem(item: Item) : Observable<Item>
  //{
    //return this.http.put<Item>(this.invUrl, item);
  //}




}
