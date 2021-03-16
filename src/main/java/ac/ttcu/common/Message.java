package ac.ttcu.common;

import org.springframework.http.HttpStatus;

public class Message {
  private  HttpStatus httpStatus;
  private  String text;
  private int code;
  private Object object;

    public Message(HttpStatus httpStatus, String text) {
        this.httpStatus = httpStatus;
        this.text = text;
        this.code=httpStatus.value();
    }

    public Message(HttpStatus httpStatus, String text, Object object) {
        this.httpStatus = httpStatus;
        this.text = text;
        this.code=httpStatus.value();
        this.object = object;
    }

    public Message(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code=httpStatus.value();
    }

    public Message() {
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code=httpStatus.value();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
