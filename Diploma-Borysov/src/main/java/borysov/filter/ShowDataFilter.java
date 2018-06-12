package borysov.filter;

import borysov.database.transaction.TransactionManager;
import borysov.database.transaction.jdbc.JdbcTransactionManager;
import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.service.StuffService;
import borysov.service.impl.StuffServiceImpl;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "ShowDataFilter")
public class ShowDataFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(ShowDataFilter.class);
    List<Stuff> stuffList;
    private TransactionManager transactionManager= new JdbcTransactionManager();
    private StuffService stuffService = new StuffServiceImpl(transactionManager);
    private String encoding;

    public ShowDataFilter() throws NamingException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        LOG.info("SHow Data filter");
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        User user = (User) httpRequest.getSession().getAttribute("currentUser");
        stuffList = stuffService.getStuff(user.getId());
        httpRequest.getSession().setAttribute("stuffList", stuffList);
        chain.doFilter(httpRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
