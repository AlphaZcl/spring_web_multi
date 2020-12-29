package app.test.common.json.mivs.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 接收方信息
 *
 * @author zclys
 * @date 2020/12/28 14:37
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstdPty {

    @JacksonXmlProperty(localName = "InstdDrctPty")
    private String instdDrctPty;

    @JacksonXmlProperty(localName = "InstdPty")
    private String instdPty;

    public String getInstdDrctPty() {
        return instdDrctPty;
    }

    public void setInstdDrctPty(String instdDrctPty) {
        this.instdDrctPty = instdDrctPty;
    }

    public String getInstdPty() {
        return instdPty;
    }

    public void setInstdPty(String instdPty) {
        this.instdPty = instdPty;
    }

    @Override
    public String toString() {
        return "InstdPty{" +
                "instdDrctPty='" + instdDrctPty + '\'' +
                ", instdPty='" + instdPty + '\'' +
                '}';
    }
}
