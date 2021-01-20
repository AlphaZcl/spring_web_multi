package top.app.VO.mivs.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 分片报文信息
 *
 * @author zclys
 * @date 2020/12/28 15:16
 */
public class MsgPgnTn {

    /**
     * 本文页码
     */
    @JacksonXmlProperty(localName = "PgNb")
    private String pgNb;

    /**
     * 最后一页指示符，最后一页（true）
     */
    @JacksonXmlProperty(localName = "LastPgInd")
    private String lastPgInd;

    public String getPgNb() {
        return pgNb;
    }

    public void setPgNb(String pgNb) {
        this.pgNb = pgNb;
    }

    public String getLastPgInd() {
        return lastPgInd;
    }

    public void setLastPgInd(String lastPgInd) {
        this.lastPgInd = lastPgInd;
    }

    @Override
    public String toString() {
        return "MsgPgnTn{" +
                "pgNb='" + pgNb + '\'' +
                ", lastPgInd='" + lastPgInd + '\'' +
                '}';
    }
}
