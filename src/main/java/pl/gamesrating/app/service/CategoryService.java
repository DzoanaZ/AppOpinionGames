package pl.gamesrating.app.service;

import pl.gamesrating.app.model.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Iterable<Category> getAllCategories();
    Category getCategoryById (Long id);

    void deleteCategory(Category category);
    Iterable<Category> getCategoriesByName(String name);

}
