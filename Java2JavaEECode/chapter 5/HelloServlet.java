import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
    /**
     * Servlet启动时调用的函数
     */
    public void init() {
        System.out.println("init() was called.");
    }

    /**
     * 处理客户端的请求
     * @param req 客户端请求
     * @param res 客户端响应
     */
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
       
        System.out.println("service() was called.");
        res.setContentType("text/html; charset=UTF-8");
        // 获取输出流对象
        PrintWriter out = res.getWriter();
        // 发送HTML内容
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello, Servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello, Servlet!");
        out.println("</body>");
        out.println("</html>");
    }
   
    /**
     * Servlet结束时调用的函数
     */
    public void destroy() {
        System.out.println("destroy() was called.");
    }
}
