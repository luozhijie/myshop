package lzj.DAO;

import java.util.ArrayList;

import lzj.entity.Category;

public interface CategoryDao {
	public int addCategory(Category category);

	public int delAdderss(Category category);

	public int updateCategory(Category category);

	public ArrayList<Category> findCategoryByCid(int cid);

	public ArrayList<Category> findAllCategory();
}
