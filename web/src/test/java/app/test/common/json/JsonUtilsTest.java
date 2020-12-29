package app.test.common.json;

import app.test.BaseTest;
import app.test.common.json.mivs.common.InstdPty;
import app.test.common.json.mivs.common.InstgPty;
import app.test.common.json.mivs.common.MessageHeader;
import app.test.common.json.mivs.common.req.mivs320.MIVS320;
import app.test.common.json.mivs.common.req.mivs320.MIVS320RootElm;
import app.test.common.json.mivs.common.req.mivs320.VryDef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import top.app.dao.entity.UserInfo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试类 Jackson api测试
 *
 * @author zclys
 * @date 2020/12/23 15:37
 */
public class JsonUtilsTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtilsTest.class);

    private Object object;

    @Value("${miv.xmlns}")
    private String nameSpace;

    @Value("${miv.325}")
    private String msgType;

    @Before
    public void testBefore(){
        /*数据准备*/
        UserInfo userInfo = new UserInfo();
        userInfo.setSysId(1);
        userInfo.setUserAcco("user0001");
        userInfo.setUserName("我的亚索没有R");
        userInfo.setPhoneNo("11111111111");
        userInfo.setEmail("123@163.com");
        userInfo.setSalary(new BigDecimal(9999));
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("jnl","123456789");
        head.put("SvrCod","000001");
        head.put("MsgID","123456789");
        Map<String, Object> body = new HashMap<>();
        List<UserInfo> resUserList = new ArrayList<>();
        resUserList.add(userInfo);
        resUserList.add(userInfo);
        body.put("resUserList",resUserList);
        resMap.put("head",head);
        resMap.put("body",body);
        object = resMap;
    }

    @Test
    public void testObjParse2Json(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(object);
//            System.out.println("jsonStr:"+jsonStr);
            logger.info("jsonStr:{}",jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObjParse2Xml(){
        XmlMapper xmlMapper = new XmlMapper();
        UserRes userRes = new UserRes();
        Map<String,Object> adminMap = (Map<String, Object>)object;
        userRes.setHead((Map<String, Object>) adminMap.get("head"));
        userRes.setBody((Map<String, Object>) adminMap.get("body"));
        userRes.setXmlns("urn:cnaps:std:mivs:2010:tech:xsd:mivs:325.001.01");
        try {
            String xmlStr = xmlMapper.writeValueAsString(userRes);
            logger.info("xmlStr:{}",xmlStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObjRead2Xml(){
        MIVS320RootElm document = new MIVS320RootElm();
        String nameSpace= "urn:cnaps:std:mivs:2010:tech:xsd:mivs:320.001.01";
        document.setXmlns(nameSpace);
        MIVS320 getIdVrfctn = new MIVS320();
        //头信息
        MessageHeader msgHdr = new MessageHeader();
        msgHdr.setMsgId("2020113009113225");
        //发送时间
        msgHdr.setCreDtTm(dateFormat(new Date()));
        InstgPty instgPty = new InstgPty();
        instgPty.setInsTgDrctPty("313521006000");
//        instgPty.setDrctPtyNm("湖北银行");
        instgPty.setInsTgPty("313532000017");
//        instgPty.setPtyNm("湖北银行荆门分行营业部");
        msgHdr.setInstgPty(instgPty);
        InstdPty instdPty = new InstdPty();
        instdPty.setInstdDrctPty("0000");
        instdPty.setInstdPty("0000");
        msgHdr.setInstdPty(instdPty);
        getIdVrfctn.setMsgHdr(msgHdr);
        //体信息
        VryDef vryDef = new VryDef();
        vryDef.setMobNb("8618666060606");
        vryDef.setNm("旭格门窗有限公司");
        vryDef.setIdTp("ICOO");
        vryDef.setId("110123456789");
        vryDef.setUnisocCdtCd("123456789");
        vryDef.setOpNm("王冉");
        getIdVrfctn.setVryDef(vryDef);
        document.setGetIdVrfctn(getIdVrfctn);

        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xmlStr = xmlMapper.writeValueAsString(document);
            logger.info("xmlStr:{}",xmlStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadXml2Obj(){
        String xmlStr  = "<Document xmlns=\"urn:cnaps:std:mivs:2010:tech:xsd:mivs:320.001.01\">\n" +
                "\t<GetIdVrfctn>\n" +
                "\t\t<MsgId>\n" +
                "\t\t\t<MsgId>2020113009113225</MsgId>\n" +
                "\t\t\t<CreDtTm>2020-12-29T08:12:14</CreDtTm>\n" +
                "\t\t\t<InstgPty>\n" +
                "\t\t\t\t<InsTgDrctPty>313521006000</InsTgDrctPty>\n" +
                "\t\t\t\t<InsTgPty>313532000017</InsTgPty>\n" +
                "\t\t\t</InstgPty>\n" +
                "\t\t\t<InstdPty>\n" +
                "\t\t\t\t<InstdDrctPty>0000</InstdDrctPty>\n" +
                "\t\t\t\t<InstdPty>0000</InstdPty>\n" +
                "\t\t\t</InstdPty>\n" +
                "\t\t</MsgId>\n" +
                "\t\t<VryDef>\n" +
                "\t\t\t<MobNb>8618666060606</MobNb>\n" +
                "\t\t\t<Nm>旭格门窗有限公司</Nm>\n" +
                "\t\t\t<IdTp>ICOO</IdTp>\n" +
                "\t\t\t<Id>110123456789</Id>\n" +
                "\t\t\t<UnisocCdtCd>123456789</UnisocCdtCd>\n" +
                "\t\t\t<BizRegNb/>\n" +
                "\t\t\t<OpNm>王冉</OpNm>\n" +
                "\t\t</VryDef>\n" +
                "\t</GetIdVrfctn>\n" +
                "</Document>\n";
        XmlMapper xmlMapper = new XmlMapper();
        try {
            MIVS320RootElm po = xmlMapper.readValue(xmlStr,MIVS320RootElm.class);
            logger.info("POJO:{}",po);
            logger.info("xmlns:{}",po.getXmlns());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private String dateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        String formDt = sdf.format(date).replaceAll("\\s","T");
        return formDt;
    }

    @Test
    public void testFunc(){
        logger.info("now:{}",dateFormat(new Date()));
    }

}
