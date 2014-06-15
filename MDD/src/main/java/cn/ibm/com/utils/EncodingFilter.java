package cn.ibm.com.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

    private String encoding;

    private boolean ignore = true;

    public void destroy() {
        this.encoding = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (ignore || (request.getCharacterEncoding() == null)) {
            String encoding = getEncoding();
            if (encoding != null) {
                request.setCharacterEncoding(encoding);
            }
        }
        response.setContentType("text/html;charset=" + encoding);
        chain.doFilter(request, response);
    }

    private String getEncoding() {
        return this.encoding;
    }

    public void init(FilterConfig filterconfig) throws ServletException {
        this.encoding = filterconfig.getInitParameter("encoding");
        String value = filterconfig.getInitParameter("ignore");
        if (value == null) {
            this.ignore = true;
        } else if (value.equalsIgnoreCase("true")) {
            this.ignore = true;
        }
    }
}