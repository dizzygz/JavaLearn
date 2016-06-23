import javax.jms.*;
import javax.naming.*;
public class SimpleTopicPublisher {
    public static void main(String[] args) {
        String                  topicName = null;
        Context                 jndiContext = null;
        TopicConnectionFactory  topicConnectionFactory = null;
        TopicConnection         topicConnection = null;
        TopicSession            topicSession = null;
        Topic                   topic = null;
        TopicPublisher          topicPublisher = null;
        TextMessage             message = null;
        final int               NUM_MSGS;
        
        if ( (args.length < 1) || (args.length > 2) ) {
            System.out.println("Usage: java " + "SimpleTopicPublisher <topic-name> " +
                "[<number-of-messages>]");
            System.exit(1);
        } 
        topicName = new String(args[0]);
        System.out.println("Topic name is " + topicName);
        if (args.length == 2){
            NUM_MSGS = (new Integer(args[1])).intValue();
        } else {
            NUM_MSGS = 1;
        }
        
        /* 
         * 创建JNDI上下文
        */
        try {
            jndiContext = new InitialContext();
        } catch (NamingException e) {
            System.out.println("Could not create JNDI API " +"context: " + e.toString());
            e.printStackTrace();
            System.exit(1);
        }
         /* 
         *查找连接工厂和话题
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
         * 创建连接和会话，并且创建发布者和消息，发送消息关闭连接。
        */
        try {
            topicConnection = topicConnectionFactory.createTopicConnection();
            topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            topicPublisher = topicSession.createPublisher(topic);
            message = topicSession.createTextMessage();
            for (int i = 0; i < NUM_MSGS; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Publishing message: " + message.getText());
                topicPublisher.publish(message);
            }
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + 
                e.toString());
        } finally {
            if (topicConnection != null) {
                try {
                    topicConnection.close();
                } catch (JMSException e) {}
            }
        }
    }
}
