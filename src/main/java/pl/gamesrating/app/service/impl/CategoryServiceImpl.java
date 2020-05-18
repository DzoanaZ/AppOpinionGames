package pl.gamesrating.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gamesrating.app.DAO.Category;
import pl.gamesrating.app.DTO.CategoryDTO;
import pl.gamesrating.app.repository.CategoryRepository;
import pl.gamesrating.app.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = convertToDAO(categoryDTO);
        category = categoryRepository.save(category);
        return convertToDTO(category);
    }
    private Category convertToDAO(CategoryDTO dto){
        Category dao = new Category();
        dao.setId(dto.getId());
        dao.setName(dto.getName());
        return dao;
    }

    private CategoryDTO convertToDTO (Category dao){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(dao.getId());
        dto.setName(dao.getName());
        return dto;
    }
}
