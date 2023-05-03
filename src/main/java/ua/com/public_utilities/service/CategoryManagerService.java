package ua.com.public_utilities.service;

import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManagerService {

    private final CategoryRepository categoryRepository;

    public CategoryManagerService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category saveCategory(String name, String descr, String image){

        Category category = new Category();
        category.setName(name);
        category.setDescription(descr);
        category.setImage(image);

        Category category1 =  categoryRepository.save(category);

        return  category1;
    }

    public Category updateCategory(Long id, String name, String descr, String image){

        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(descr);
        category.setImage(image);

        Category category1 =  categoryRepository.save(category);

        return  category1;
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


    public void deleteAllCategory(){
        categoryRepository.deleteAll();
    }


    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){

        Optional<Category> categories = categoryRepository.findById(id);

        if(categories.isEmpty()){
            return null;
        } else {
            return categories.get();
        }
    }

    public Category getCategoryByName(String name) {

        return categoryRepository.findByName(name);
    }


}