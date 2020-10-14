package com.platzi.platzimarket2.domain;

public class Product {
  private int productId;
  private String name;
  private int categoryId;
  private double price;
  private int stock;
  private boolean active;
  private Category category;

  public Product(int productId, String name, int categoryId, double price, int stock, boolean active, Category category) {
    this.productId = productId;
    this.name = name;
    this.categoryId = categoryId;
    this.price = price;
    this.stock = stock;
    this.active = active;
    this.category = category;
  }

  public Product() {
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
