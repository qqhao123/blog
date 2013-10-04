package blog.web.action.blog;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import blog.model.Blog;

import blog.service.IBlogService;

import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6768577375235506443L;

	private InputStream inputStream;

	private IBlogService blogService;

	public IBlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	private Blog blog;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	@Action(value = "getBlogContent", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "text/html" }) })
	public String getBlogContent() throws UnsupportedEncodingException {
        System.out.println("test");
		Blog blog = blogService.getBlog(this.blog);
		inputStream = new ByteArrayInputStream(blog.getContent().getBytes("UTF-8"));
		return SUCCESS;
	}
}
