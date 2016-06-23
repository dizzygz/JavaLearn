/**
 * @author Chao Wu
 * 
 * Description:
 * <p>
 * 
 * Copyright:
 * <p>
 */
//USER±íµÄVOÀà
public class User {
      private String username;
      private String password;
      private int id;
      /**
       * @return
       */
      public int getId() {
            return id;
      }
      /**
       * @param id
       */
      public void setId(int id) {
            this.id = id;
      }
      /**
       * @return
       */
      public String getPassword() {
            return password;
      }
      /**
       * @return
       */
      public String getUsername() {
            return username;
      }
      /**
       * @param password
       */
      public void setPassword(String password) {
            this.password = password;
      }
      /**
       * @param username
       */
      public void setUsername(String username) {
            this.username = username;
      }
}
