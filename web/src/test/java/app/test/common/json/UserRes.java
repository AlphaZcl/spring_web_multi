package app.test.common.json;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.Map;

/**
 * @author zclys
 * @date 2020/12/25 17:56
 */
@JacksonXmlRootElement(localName = "UserInfo")
public class UserRes {

    @JacksonXmlText
    private String text;

    @JacksonXmlProperty(localName = "head")
    private Map<String,Object> head;

    @JacksonXmlProperty(localName = "body")
    private Map<String,Object> body;

    @JacksonXmlProperty(isAttribute = true,localName = "xmlns")
    private String xmlns;

    public Map<String, Object> getHead() {
        return head;
    }

    public void setHead(Map<String, Object> head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
