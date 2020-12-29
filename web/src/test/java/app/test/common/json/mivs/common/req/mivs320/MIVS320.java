package app.test.common.json.mivs.common.req.mivs320;

import app.test.common.json.mivs.common.MessageHeader;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * mivs320报文
 *
 * @author zclys
 * @date 2020/12/28 15:21
 */
public class MIVS320 {

    /**
     * 请求头信息
     */
    @JacksonXmlProperty(localName = "MsgId")
    private MessageHeader msgHdr;

    /**
     * 请求业务信息
     */
    @JacksonXmlProperty(localName = "VryDef")
    private VryDef vryDef;

    public MessageHeader getMsgHdr() {
        return msgHdr;
    }

    public void setMsgHdr(MessageHeader msgHdr) {
        this.msgHdr = msgHdr;
    }

    public VryDef getVryDef() {
        return vryDef;
    }

    public void setVryDef(VryDef vryDef) {
        this.vryDef = vryDef;
    }

    @Override
    public String toString() {
        return "MIVS320{" +
                "msgHdr=" + msgHdr +
                ", vryDef=" + vryDef +
                '}';
    }
}
