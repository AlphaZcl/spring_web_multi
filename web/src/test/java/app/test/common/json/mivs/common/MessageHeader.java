package app.test.common.json.mivs.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

/**
 * 公共头信息，包含发送方信息和接收方信息，请求报文与应答报文头信息
 *
 * @author zclys
 * @date 2020/12/25 10:15
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageHeader {

    /**
     * 报文标识号
     */
    @JacksonXmlProperty(localName = "MsgId")
    private String msgId;

    /**
     * 报文发送时间
     */
    @JacksonXmlProperty(localName = "CreDtTm")
    private String creDtTm;

    /**
     * 分片报文信息
     */
    @JacksonXmlProperty(localName = "MsgPgnTn")
    private MsgPgnTn msgPgnTn;

    /**
     * 报文发送方信息
     */
    @JacksonXmlProperty(localName = "InstgPty")
    private InstgPty instgPty;

    /**
     * 报文接收方信息
     */
    @JacksonXmlProperty(localName = "InstdPty")
    private InstdPty instdPty;

    /**
     * 原报文信息
     */
    @JacksonXmlProperty(localName = "OrgnlBizQry")
    private OrgnlBizQry orgnlBizQry;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCreDtTm() {
        return creDtTm;
    }

    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }

    public MsgPgnTn getMsgPgnTn() {
        return msgPgnTn;
    }

    public void setMsgPgnTn(MsgPgnTn msgPgnTn) {
        this.msgPgnTn = msgPgnTn;
    }

    public InstgPty getInstgPty() {
        return instgPty;
    }

    public void setInstgPty(InstgPty instgPty) {
        this.instgPty = instgPty;
    }

    public InstdPty getInstdPty() {
        return instdPty;
    }

    public void setInstdPty(InstdPty instdPty) {
        this.instdPty = instdPty;
    }

    public OrgnlBizQry getOrgnlBizQry() {
        return orgnlBizQry;
    }

    public void setOrgnlBizQry(OrgnlBizQry orgnlBizQry) {
        this.orgnlBizQry = orgnlBizQry;
    }

    @Override
    public String toString() {
        return "MessageHeader{" +
                "msgId='" + msgId + '\'' +
                ", creDtTm=" + creDtTm +
                ", msgPgnTn=" + msgPgnTn +
                ", instgPty=" + instgPty +
                ", instdPty=" + instdPty +
                ", orgnlBizQry=" + orgnlBizQry +
                '}';
    }
}
