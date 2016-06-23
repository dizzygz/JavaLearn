import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.event.FacesEvent;
import javax.faces.lifecycle.ApplicationHandler;
import javax.faces.tree.TreeFactory;
//�¼�������
public class SimpleApplicationHandler implements ApplicationHandler {
   public boolean processEvent(FacesContext context, FacesEvent facesEvent) {
      //�����Ӧ��
      TreeFactory treeFactory = (TreeFactory)FactoryFinder.getFactory(FactoryFinder.TREE_FACTORY);
      //������Ӧ��
      context.setResponseTree(treeFactory.getTree(context.getServletContext(),"/welcome.jsp"));
      return true;
   }
}
