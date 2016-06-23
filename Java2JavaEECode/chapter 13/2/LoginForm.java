import org.apache.struts.action.*;
/**
 * @author Chao Wu
 * 
 * Description:
 * <p>
 * 
 * Copyright:
 * <p>
 */
public class LoginForm extends ActionForm {
      //����Ϊ��Ա�Ķ���
      private static final long serialVersionUID = 1L;
      //�û���
      private String username;
      //����
      private String password;
      //������
      private String newPassword;
      /������ȷ��
      private String confirmPassword;
      //����Ա���óɳ�ʼֵ
      public void resetManually()
      {
            username = null;
            password = null;
            newPassword = null;
            confirmPassword = null;
            errorMessage = null;
      }
      //������Ϣ
      private String errorMessage;
      /**
       * @return
       */
      public String getErrorMessage() {
            return errorMessage;
      }
      /**
       * @param errorMessage
       */
      public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
      }
      /**
       * @return
       */
      public String getConfirmPassword() {
            return confirmPassword;
      }
      /**
       * @param confirmPassword
       */
      public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
      }
      /**
       * @return
       */
      public String getNewPassword() {
            return newPassword;
      }
      /**
       * @param newPassword
       */
      public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
      }
      /**
       * @return
       */
      public String getPassword() {
            return password;
      }
      /**
       * @param password
       */
      public void setPassword(String password) {
            this.password = password;
      }
      /**
       * @return
       */
      public String getUsername() {
            return username;
      }
      /**
       * @param username
       */
      public void setUsername(String username) {
            this.username = username;
      }
}
