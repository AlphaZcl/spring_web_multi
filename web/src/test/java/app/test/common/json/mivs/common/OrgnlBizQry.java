package app.test.common.json.mivs.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 原报文信息
 *
 * @author zclys
 * @date 2020/12/28 15:27
 */
public class OrgnlBizQry {

    /**
     * 原报文标识号
     */
    @JacksonXmlProperty(localName = "MsgId")
    private String msgId;

    /**
     * 原报文发起方信息
     */
    @JacksonXmlProperty(localName = "InstgPty")
    private InstgPty oInstgPty;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public InstgPty getoInstgPty() {
        return oInstgPty;
    }

    public void setoInstgPty(InstgPty oInstgPty) {
        this.oInstgPty = oInstgPty;
    }

    @Override
    public String toString() {
        return "OrgnlBizQry{" +
                "msgId='" + msgId + '\'' +
                ", oInstgPty=" + oInstgPty +
                '}';
    }
}
