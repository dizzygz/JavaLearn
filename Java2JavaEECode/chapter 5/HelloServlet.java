import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {
    /**
     * Servlet����ʱ���õĺ���
     */
    public void init() {
        System.out.println("init() was called.");
    }

    /**
     * ����ͻ��˵�����
     * @param req �ͻ�������
     * @param res �ͻ�����Ӧ
     */
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
       
        System.out.println("service() was called.");
        res.setContentType("text/html; charset=UTF-8");
        // ��ȡ���������
        PrintWriter out = res.getWriter();
        // ����HTML����
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
     * Servlet����ʱ���õĺ���
     */
    public void destroy() {
        System.out.println("destroy() was called.");
    }
}
