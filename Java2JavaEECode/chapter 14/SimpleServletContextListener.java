import javax.servlet.*;
import javax.faces.*;
import javax.faces.lifecycle.*;
public class SimpleServletContextListener implements ServletContextListener {
   public void contextInitialized(ServletContextEvent e) {
      //生成生命周期对象
      LifecycleFactory factory = (LifecycleFactory)
        FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
      Lifecycle lifecycle = factory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
      //注册事件处理类
      lifecycle.setApplicationHandler(new SimpleApplicationHandler());
   }
   public void contextDestroyed(ServletContextEvent e) {
      // Nothing to do here
   }

}
