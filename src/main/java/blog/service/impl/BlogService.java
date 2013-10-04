package blog.service.impl;

import java.util.List;
import blog.dao.BlogDao;
import blog.model.Blog;
import blog.model.Tag;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import blog.service.IBlogService;

public class BlogService implements IBlogService {
	private BlogDao blogDao;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void insertBlog(Blog blog) throws Exception {
		blogDao.insertBlog(blog);
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public BlogDao getBlogDao() {
		return blogDao;
	}

	public Blog getBlog(Blog blog) {
		return blogDao.getBlog(blog);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void addTagToBlog(long blogId, Tag tag) throws Exception {
		blogDao.addTag(blogId, tag);
		throw new RuntimeException("hhh");
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor =
	java.lang.RuntimeException.class)
	public void addBlogTestTsc(Blog blog, Tag tag) throws Exception {
		insertBlog(blog);
		addTagToBlog(blog.getBlogId(), tag);
	}

	public List<Blog> getBlogsForIndex(int row) {
		return blogDao.getIndexBolgs(row);
	}
}
