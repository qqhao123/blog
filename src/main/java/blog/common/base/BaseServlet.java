package blog.common.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9209407943260198271L;
	WebApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		super.init();
		context =WebApplicationContextUtils
		.getRequiredWebApplicationContext(this.getServletContext());
	}
	
	protected Object getServiceBean(String beanName)
	{
		return context.getBean(beanName);
	}
	
	protected <T> T getServiceBean(Class<T> cls)
	{
		return context.getBean(cls);
	}
}
