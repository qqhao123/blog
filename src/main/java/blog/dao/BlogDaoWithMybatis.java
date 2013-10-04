package blog.dao;

import java.util.List;

import blog.common.lang.Tuple;

import blog.mappers.BlogMapper;
import blog.model.Blog;
import blog.model.Tag;

public class BlogDaoWithMybatis implements BlogDao {
	private BlogMapper blogMapper;

	public BlogMapper getBlogMapper() {
		return blogMapper;
	}

	public void setBlogMapper(BlogMapper blogMapper) {
		this.blogMapper = blogMapper;
	}

	public void insertBlog(Blog blog) {
		blogMapper.insertBlog(blog);
	}

	public Blog getBlog(Blog blog) {

		/*
		 * SqlSession sqlSession = SqlSessionUtils
		 * .getSqlSession(sqlSessionFactory); BlogMapper blogMapper =
		 * sqlSession.getMapper(BlogMapper.class);
		 */
		return blogMapper.selectBlog(blog);
	}

	public void addTag(long blogId, Tag tag) {
		Long tagId = blogMapper.findTagId(tag.getTagName());
		if (tagId != null)
			blogMapper.addTagForBlog(new Tuple<Long, Long>(blogId, tagId));
		else {
			blogMapper.insertTag(tag);
			blogMapper
					.addTagForBlog(new Tuple<Long, Long>(blogId, tag.getId()));
		}
	}

	public List<Blog> getIndexBolgs(int pageRow) {
		return blogMapper.selectIndexBlogs(pageRow);
	}
}
