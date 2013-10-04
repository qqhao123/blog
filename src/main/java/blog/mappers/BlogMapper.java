package blog.mappers;

import java.util.List;

import blog.common.lang.Tuple;

import blog.model.Blog;
import blog.model.Tag;

public interface BlogMapper {
	public Blog selectBlog(Blog blog);
	
	public List<Blog> selectIndexBlogs(int row);

	public void insertBlog(Blog blog);

	public void insertTag(Tag tag);

	public Long findTagId(String tagName);

	public void addTagForBlog(Tuple<Long, Long> t);
}
