package com.supinfo.rmt.filters;

import com.supinfo.rmt.controllers.UserController;
import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.Manager;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francois
 */
@WebFilter(filterName = "EmployeeFilter", urlPatterns = {"/faces/add_worktime.xhtml", "/faces/employee_home.xhtml"})
public class EmployeeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        UserController userController = (UserController) session.getAttribute("userController");
        if (userController != null) {
            if (userController.getUser() instanceof Employee) {
                chain.doFilter(request, response);
                return;
            }
            if (userController.getUser() instanceof Manager) {
                ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/faces/manager_home.xhtml");
                return;
            }
        }
        ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/faces/login.xhtml");
    }

    @Override
    public void destroy() {
    }
}
