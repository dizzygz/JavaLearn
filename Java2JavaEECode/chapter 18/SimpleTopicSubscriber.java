import javax.jms.*;
import javax.naming.*;
import java.io.*;
public class SimpleTopicSubscriber {
    public static void main(String[] args) {
        String                  topicName = null;
        Context                 jndiContext = null;
        TopicConnectionFactory  topicConnectionFactory = null;
        TopicConnection         topicConnection = null;
        TopicSession            topicSession = null;
        Topic                   topic = null;
        TopicSubscriber         topicSubscriber = null;
        TextListener            topicListener = null;
        TextMessage             message = null;
        InputStreamReader       inputStreamReader = null;
        char                    answer = '\0';
                
        /*
         * �������������л�ȡ��������
         */
        if (args.length != 1) {
            System.out.println("Usage: java " + "SimpleTopicSubscriber <topic-name>");
            System.exit(1);
        }
        topicName = new String(args[0]);
        System.out.println("Topic name is " + topicName);
        /* 
         *����JNDI������
         */
        try {
            jndiContext = new InitialContext();
        } catch (NamingException e) {
            System.out.println("Could not create JNDI API " + "context: " + e.toString());
            e.printStackTrace();
            System.exit(1);
        }
        /* 
         * �������ӹ����ͻ���
         */
        try {
            topicConnectionFactory = (TopicConnectionFactory)
                jndiContext.lookup("TopicConnectionFactory");
            topic = (Topic) jndiContext.lookup(topicName);
        } catch (NamingException e) {
            System.out.println("JNDI API lookup failed: " + e.toString());
            e.printStackTrace();
            System.exit(1);
        }
        /*
         * �������ӺͻỰ�����������߲�ע����Ϣ����������ȡ��Ϣ
        */
        try {
            topicConnection = topicConnectionFactory.createTopicConnection();
            topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            topicSubscriber = topicSession.createSubscriber(topic);
            topicListener = new TextListener();
            topicSubscriber.setMessageListener(topicListener);
            topicConnection.start();
            System.out.println("To end program, enter Q or q, " + "then <return>");
            inputStreamReader = new InputStreamReader(System.in);
            while (!((answer == 'q') || (answer == 'Q'))) {
                try {
                    answer = (char) inputStreamReader.read();
                } catch (IOException e) {
                    System.out.println("I/O exception: " + e.toString());
                }
            }
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
        } finally {
            if (topicConnection != null) {
                try {
                    topicConnection.close();
                } catch (JMSException e) {}
            }
        }
    }
}
