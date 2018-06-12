package borysov.filter;

import borysov.entity.User;
import borysov.utility.Dispatcher;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class AuthorizationUserFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(AuthorizationUserFilter.class);
    private Dispatcher dispatcher = new Dispatcher();


    public void init(FilterConfig fConfig) throws ServletException {
        LOG.debug("AuthorizationUserFilter");
    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        LOG.debug(" AuthorizationUserFilter");

        HttpServletRequest tempRequest = (HttpServletRequest) request;
        HttpServletResponse tempResponse = (HttpServletResponse) response;
        if (!dispatcher.isAccountUser(tempRequest, tempResponse)) {
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        LOG.debug("Filter AuthorizationUserFilter destruction");
    }


}
