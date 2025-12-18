package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;


    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }


    @GetMapping("")
    public List<Category> getAll() {

        return categoryDao.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        Category category = categoryDao.getById(id);
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oops, error occurred. Try again.");
        }
        return category;
//        try {
//            var category = categoryDao.getById(id);
//            if (category == null)
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//            return category;
//        } catch (ResponseStatusException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, error occurred. Try again");
//        }
//        return categoryDao.getById(id);
//        return null;

    }


    @GetMapping("/{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        return productDao.listByCategoryId(categoryId);
        //return productDao.getBYId(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.create(category);

//        try {
//            return categoryDao.create(category);
//        } catch (Exception ex) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, error occurred. Try again.");
//        }


    }


   @PutMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);

//        try {
//            categoryDao.update(id, category);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, error occurred. Try again.");
//        }


    }


   @DeleteMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN')")
   @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        var category = categoryDao.getById(id);
        if (category == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        categoryDao.delete(id);
//        try {
//            var category = categoryDao.getById(id);
//            if (category == null)
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//            categoryDao.delete(id);
//        } catch (Exception ex) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, error occurred. Try again.");
//        }



    }
}
