import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
public class SpringDemo {
public static void main(String[] args) {
	   //�����ļ���λ��
Resource rs =new FileSystemResource("beans-config.xml");
BeanFactory factory =new XmlBeanFactory(rs);
//����Bean
HelloBean hello =(HelloBean) factory.getBean("helloBean");
//����Bean�ķ�������ӡ�ʺ���
System.out.println(hello.getHelloWord());
}
} 
