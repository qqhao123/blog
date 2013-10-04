package blog.service;

import java.util.List;

import blog.model.Blog;
import blog.model.Tag;

public interface IBlogService {
	public void insertBlog(Blog blog) throws Exception;
	
	public Blog getBlog(Blog blog);

	public void addTagToBlog(long blogId, Tag tag) throws Exception;

	public void addBlogTestTsc(Blog blog, Tag tag) throws Exception;
	
	public List<Blog> getBlogsForIndex(int row);
}
