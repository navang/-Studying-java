package guest.model;

public class Message {
			// property : 한 테이블의 컬럼들
			// property name 변수명 : 폼의 name과 동일 
	
			int messageID;
			String guestName;
			String password;
			String message;
						
			
			public int getMessageID() {
				return messageID;
			}
			public void setMessageID(int messageID) {
				this.messageID = messageID;
			}
			public String getGuestName() {
				return guestName;
			}
			public void setGuestName(String gestName) {
				this.guestName = gestName;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			
			
			
}
