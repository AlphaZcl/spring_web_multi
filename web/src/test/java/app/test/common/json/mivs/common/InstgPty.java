package app.test.common.json.mivs.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 发送方信息
 *
 * @author zclys
 * @date 2020/12/28 14:30
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstgPty {

    @JacksonXmlProperty(localName = "InsTgDrctPty")
    private String insTgDrctPty;

    @JacksonXmlProperty(localName = "DrctPtyNm")
    private String drctPtyNm;

    @JacksonXmlProperty(localName = "InsTgPty")
    private String insTgPty;

    @JacksonXmlProperty(localName = "PtyNm")
    private String ptyNm;

    public String getInsTgDrctPty() {
        return insTgDrctPty;
    }

    public void setInsTgDrctPty(String insTgDrctPty) {
        this.insTgDrctPty = insTgDrctPty;
    }

    public String getDrctPtyNm() {
        return drctPtyNm;
    }

    public void setDrctPtyNm(String drctPtyNm) {
        this.drctPtyNm = drctPtyNm;
    }

    public String getInsTgPty() {
        return insTgPty;
    }

    public void setInsTgPty(String insTgPty) {
        this.insTgPty = insTgPty;
    }

    public String getPtyNm() {
        return ptyNm;
    }

    public void setPtyNm(String ptyNm) {
        this.ptyNm = ptyNm;
    }

    @Override
    public String toString() {
        return "InstgPty{" +
                "insTgDrctPty='" + insTgDrctPty + '\'' +
                ", drctPtyNm='" + drctPtyNm + '\'' +
                ", insTgPty='" + insTgPty + '\'' +
                ", ptyNm='" + ptyNm + '\'' +
                '}';
    }
}
