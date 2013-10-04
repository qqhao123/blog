package blog.dao;

import java.util.List;

import blog.model.Blog;
import blog.model.Tag;

public interface BlogDao {
	public void insertBlog(Blog blog) throws Exception;
	public void addTag(long blogId, Tag tag) throws Exception;
	public Blog getBlog(Blog blog);
	public List<Blog> getIndexBolgs(int pageRow);
}
