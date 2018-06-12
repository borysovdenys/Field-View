package borysov.filter;

import borysov.database.transaction.TransactionManager;
import borysov.database.transaction.jdbc.JdbcTransactionManager;
import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.service.StuffService;
import borysov.service.UserService;
import borysov.service.impl.StuffServiceImpl;
import borysov.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "AdminDataFilter")
public class AdminDataFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(AdminDataFilter.class);
    List<User> userList;
    private UserService userService;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        LOG.info("SHow Data filter");
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        userList = userService.getListOfUsers();
        httpRequest.getSession().setAttribute("userList", userList);
        chain.doFilter(httpRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

}
