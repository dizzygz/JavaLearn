import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
public class SpringDemo {
public static void main(String[] args) {
	   //配置文件的位置
Resource rs =new FileSystemResource("beans-config.xml");
BeanFactory factory =new XmlBeanFactory(rs);
//生成Bean
HelloBean hello =(HelloBean) factory.getBean("helloBean");
//调用Bean的方法，打印问候语
System.out.println(hello.getHelloWord());
}
} 
