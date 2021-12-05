package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "NoBrowserCacheFilter ")
public class NoBrowserCacheFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse response=(HttpServletResponse)res;
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);

        chain.doFilter(request, response);
    }
}
