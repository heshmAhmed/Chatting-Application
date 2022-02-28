package gov.iti.jets.common.dtos;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private String senderId;
    private String receiverId;
    private String messageText;
    private String messageStyle;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageStyle() {
        return messageStyle;
    }

    public void setMessageStyle(String messageStyle) {
        this.messageStyle = messageStyle;
    }


    @Override
    public String toString() {
        return "MessageDTO{" +
                "senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageStyle='" + messageStyle + '\'' +
                '}';
    }
}
