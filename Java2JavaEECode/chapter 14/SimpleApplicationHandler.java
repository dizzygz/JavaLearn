import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.event.FacesEvent;
import javax.faces.lifecycle.ApplicationHandler;
import javax.faces.tree.TreeFactory;
//事件处理类
public class SimpleApplicationHandler implements ApplicationHandler {
   public boolean processEvent(FacesContext context, FacesEvent facesEvent) {
      //获得响应树
      TreeFactory treeFactory = (TreeFactory)FactoryFinder.getFactory(FactoryFinder.TREE_FACTORY);
      //设置响应树
      context.setResponseTree(treeFactory.getTree(context.getServletContext(),"/welcome.jsp"));
      return true;
   }
}
