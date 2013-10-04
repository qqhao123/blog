package blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.*;

import blog.common.base.BaseServlet;

import blog.model.Blog;

import blog.service.IBlogService;

public class GetIndexBlogsServlet extends BaseServlet {

	private static final long serialVersionUID = 662867867539348081L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		IBlogService blogService = (IBlogService) this
				.getServiceBean("blogService");
		List<Blog> blogs1 = blogService.getBlogsForIndex(10);
		ObjectMapper mapper = new ObjectMapper();
		String json =  mapper.writeValueAsString(blogs1); //利用jackson转化成json
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
	}
}
