package com.project.leebugzz.model;

public class CategoryEntity {
private int categoryId;
private String categoryName;

 public CategoryEntity(int categoryId, String categoryName) {
super();
this.categoryId = categoryId;
this.categoryName = categoryName;
}

 public CategoryEntity() {
super();
// TODO Auto-generated constructor stub
}

 public int getCategoryId() {
return categoryId;
}

 public void setCategoryId(int categoryId) {
this.categoryId = categoryId;
}

 public String getCategoryName() {
return categoryName;
}

 public void setCategoryName(String categoryName) {
this.categoryName = categoryName;
}

}
