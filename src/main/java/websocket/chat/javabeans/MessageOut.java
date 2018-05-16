package websocket.chat.javabeans;

public class MessageOut {

    private String message;

    public MessageOut(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
