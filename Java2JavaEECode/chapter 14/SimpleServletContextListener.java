import javax.servlet.*;
import javax.faces.*;
import javax.faces.lifecycle.*;
public class SimpleServletContextListener implements ServletContextListener {
   public void contextInitialized(ServletContextEvent e) {
      //�����������ڶ���
      LifecycleFactory factory = (LifecycleFactory)
        FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
      Lifecycle lifecycle = factory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
      //ע���¼�������
      lifecycle.setApplicationHandler(new SimpleApplicationHandler());
   }
   public void contextDestroyed(ServletContextEvent e) {
      // Nothing to do here
   }

}
