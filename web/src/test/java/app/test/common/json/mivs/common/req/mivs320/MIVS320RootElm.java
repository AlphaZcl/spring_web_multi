package app.test.common.json.mivs.common.req.mivs320;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * mivs320报文pojo实体
 *
 * @author zclys
 * @date 2020/12/28 15:41
 */
@JacksonXmlRootElement(localName = "Document")
public class MIVS320RootElm {

    @JacksonXmlProperty(localName = "GetIdVrfctn")
    private MIVS320 getIdVrfctn;

    @JacksonXmlProperty(isAttribute = true,localName = "xmlns")
    private String xmlns;

    public MIVS320 getGetIdVrfctn() {
        return getIdVrfctn;
    }

    public void setGetIdVrfctn(MIVS320 getIdVrfctn) {
        this.getIdVrfctn = getIdVrfctn;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @Override
    public String toString() {
        return "MIVS320RootElm{" +
                "getIdVrfctn=" + getIdVrfctn +
                ", xmlns='" + xmlns + '\'' +
                '}';
    }
}
