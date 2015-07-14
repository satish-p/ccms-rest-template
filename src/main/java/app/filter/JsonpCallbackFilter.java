package app.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class JsonpCallbackFilter implements Filter {

	private static final String UTF_8 = "UTF-8";
	private String callbackParameterName;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Nothing
	}

	@Override
	public void destroy() {
		// Nothing
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String callback = httpRequest.getParameter(callbackParameterName);
        if(StringUtils.isEmpty(callback)) {
           	chain.doFilter(httpRequest, httpResponse);
        	return;
        }

        OutputStream out = httpResponse.getOutputStream();
        
        GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);

        chain.doFilter(request, wrapper);

        wrapper.setContentType("text/javascript;charset=UTF-8");
        out.write((callback + "(").getBytes(UTF_8));
        out.write(wrapper.getData());
        out.write(");".getBytes(UTF_8));


        out.close();
    }

	public void setCallbackParameterName(String callbackParameterName) {
		this.callbackParameterName = callbackParameterName;
	}
	
	
}
