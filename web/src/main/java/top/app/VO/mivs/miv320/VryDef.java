package top.app.VO.mivs.miv320;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * mvis320请求内容
 *
 * @author zclys
 * @date 2020/12/28 15:53
 */
public class VryDef {

    /**
     * 手机号码
     */
    @JacksonXmlProperty(localName = "MobNb")
    private String mobNb;

    /**
     * 姓名
     */
    @JacksonXmlProperty(localName = "Nm")
    private String nm;

    /**
     * 证件类型
     */
    @JacksonXmlProperty(localName = "IdTp")
    private String idTp;

    /**
     * 证件号码
     */
    @JacksonXmlProperty(localName = "Id")
    private String id;

    /**
     * 统一社会信用代码
     */
    @JacksonXmlProperty(localName = "UnisocCdtCd")
    private String unisocCdtCd;

    /**
     * 工商注册号
     */
    @JacksonXmlProperty(localName = "BizRegNb")
    private String bizRegNb;

    /**
     * 操作员姓名
     */
    @JacksonXmlProperty(localName = "OpNm")
    private String opNm;

    public String getMobNb() {
        return mobNb;
    }

    public void setMobNb(String mobNb) {
        this.mobNb = mobNb;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getIdTp() {
        return idTp;
    }

    public void setIdTp(String idTp) {
        this.idTp = idTp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnisocCdtCd() {
        return unisocCdtCd;
    }

    public void setUnisocCdtCd(String unisocCdtCd) {
        this.unisocCdtCd = unisocCdtCd;
    }

    public String getBizRegNb() {
        return bizRegNb;
    }

    public void setBizRegNb(String bizRegNb) {
        this.bizRegNb = bizRegNb;
    }

    public String getOpNm() {
        return opNm;
    }

    public void setOpNm(String opNm) {
        this.opNm = opNm;
    }

    @Override
    public String toString() {
        return "VryDef{" +
                "mobNb='" + mobNb + '\'' +
                ", nm='" + nm + '\'' +
                ", idTp='" + idTp + '\'' +
                ", id='" + id + '\'' +
                ", unisocCdtCd='" + unisocCdtCd + '\'' +
                ", bizRegNb='" + bizRegNb + '\'' +
                ", opNm='" + opNm + '\'' +
                '}';
    }
}
