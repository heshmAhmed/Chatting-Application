package gov.iti.jets.common.dtos;

public class MessageDTO {

    private String senderId;
    private String resiverId;
    private String messageText;
    private String messageStyle;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getResiverId() {
        return resiverId;
    }

    public void setResiverId(String resiverId) {
        this.resiverId = resiverId;
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


}
