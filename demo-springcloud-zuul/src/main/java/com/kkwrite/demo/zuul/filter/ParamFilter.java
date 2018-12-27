package com.kkwrite.demo.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ParamFilter extends ZuulFilter {
	
	private Logger logger = Logger.getLogger(ParamFilter.class);

	@Override
	public Object run() {
		logger.info("[ run ] ParamFilter.run() 过滤器开始执行。");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Object accessToken = request.getParameter("token");
		if (accessToken != null) {
			return null;
		}
		logger.error("必须传入 token 参数！");
		
		/*ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(401);
		try {
			ctx.getResponse().getWriter().write("必须传入 token 参数！");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return false; // 是否执行该过滤器，此处为true，说明需要过滤
	}

	@Override
	public int filterOrder() {
		return 0; // 优先级为0，数字越小，优先级越高
	}

	/**
	 * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre"; // 前置过滤器
	}

}
