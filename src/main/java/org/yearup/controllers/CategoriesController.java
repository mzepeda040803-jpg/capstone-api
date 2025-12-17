package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotations to make this a REST controller D
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests


@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;


    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }


    @GetMapping
    public List<Category> getAll() {

        return categoryDao.getAllCategories();
    }

    @GetMapping("/ {id}")
    public Category getById(@PathVariable int id) {
//        return categoryDao.getById(id);
        return null;

    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("/{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)
    {

        return productDao.listByCategoryId(categoryId);
        //return productDao.getBYId(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole( 'ADMIN' )")
//    @RequestMapping(path = " /categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
//        Product newProduct = productDao.insert(product);
       return categoryDao.create(category);

    }


    @PreAuthorize("hasRole ('ADMIN') ")
    @PutMapping("/{id}")
//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
//        category.setCategoryId(id);
        categoryDao.update(id, category);

    }


    @PreAuthorize("hasRole ('ADMIN') ")
    @DeleteMapping("/{id}")
//    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);



    }
}
