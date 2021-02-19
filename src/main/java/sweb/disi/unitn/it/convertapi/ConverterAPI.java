package sweb.disi.unitn.it.convertapi;


import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alessio Zamboni <alessio.zamboni@unitn.it>
 * @date: 02/12/2020
 */
public class ConverterAPI {

    final static Logger logger = LogManager.getLogger(ConverterAPI.class);

    public static String convertV2toV1(String body) {
        InputStream is = ConverterAPI.class.getClassLoader().getResourceAsStream("specV2toV1.json");
        Chainr chainr = Chainr.fromSpec(JsonUtils.jsonToList(is));
        Object input = JsonUtils.jsonToObject(body);
        Object output = chainr.transform(input);

        return JsonUtils.toPrettyJsonString(output);
    }

    public static String convertV1toV2(String body) {
        logger.info("Convert V1 to V2 - BODY: " + body);
        InputStream is = ConverterAPI.class.getClassLoader().getResourceAsStream("specV1toV2.json");
        Chainr chainr = Chainr.fromSpec(JsonUtils.jsonToList(is));
        Object input = JsonUtils.jsonToObject(body);
        Object output = chainr.transform(input);
        logger.info("Convert V1 to V2 - OUTPUT: " + JsonUtils.toPrettyJsonString(output));
        return JsonUtils.toPrettyJsonString(output);
    }

    public static String convertGetV1toV2(String body) {
        logger.info("Convert GET V1 to V2 - BODY: " + body);
        InputStream is = ConverterAPI.class.getClassLoader().getResourceAsStream("specGetV1toV2.json");
        Chainr chainr = Chainr.fromSpec(JsonUtils.jsonToList(is));
        Object input = JsonUtils.jsonToObject(body);
        Object output = chainr.transform(input);
        logger.info("Convert GET V1 to V2 - OUTPUT: " + JsonUtils.toPrettyJsonString(output));
        return JsonUtils.toPrettyJsonString(output);
    }

    //Testing to check paths are correct
    public static void main(String[] args) throws IOException {
        int off = 0, len = 2000;
        byte[] buff = new byte[len];
        StringBuffer sb = new StringBuffer();
        while (System.in.read(buff, off, len) == len) {
            sb.append(new String(buff));
        }
        sb.append(new String(buff));
        String string = sb.toString();
        System.out.println("input = " + string);
        System.out.println(convertV2toV1(string));
    }
}
