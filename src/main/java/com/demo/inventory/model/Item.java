package com.demo.inventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Item
 */

@Table(name = "INVENTORY")
@Entity
public class Item   {

  @Id
  @GeneratedValue
  private int sku;

  private String name;

  private int count;


  public Item sku(int sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Get sku
   * @return sku
  **/
  public int getSku() {
    return sku;
  }

  public void setSku(int sku) {
    this.sku = sku;
  }

  public Item name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Item count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  **/
  public int getCount() {

    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.sku, item.sku) &&
        Objects.equals(this.name, item.name) &&
        Objects.equals(this.count, item.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, name, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

