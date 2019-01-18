package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.List;
import java.util.Map;

public class RestUtil {
    public static <T> T getData(RestModel rest, Class<T> clazz) {
        if(rest != null && RestModel.CODE_SUCCESS ==rest.getCode()  && rest.getData() != null) {
            T model = JSON.parseObject(JSON.toJSONString(rest.getData()), clazz);
            return model;
        } else {
            return null;
        }
    }

    public static <T> List<T> getList(RestModel rest, Class<T> clazz) {
        if(rest != null && RestModel.CODE_SUCCESS ==rest.getCode()  && rest.getData() != null) {
            List<T> model = JSON.parseArray(JSON.toJSONString(rest.getData()), clazz);
            return model;
        } else {
            return null;
        }
    }

    public static <T> Map<String, T> getMap(RestModel rest, Class<T> clazz) {
        if(rest != null && RestModel.CODE_SUCCESS ==rest.getCode()  && rest.getData() != null) {
            Map<String, T> model = (Map)JSON.parseObject(JSON.toJSONString(rest.getData()), new TypeReference<Map<String, T>>() {
            }, new Feature[0]);
            return model;
        } else {
            return null;
        }
    }

    public static Map<String, Object> getMap(RestModel rest) {
        if(rest != null && (RestModel.CODE_SUCCESS ==rest.getCode())  && rest.getData() != null) {
            Map<String, Object> map = (Map)rest.getData();
            return map;
        } else {
            return null;
        }
    }

    public static List<Map<String, Object>> getMapList(RestModel rest) {
        if(rest != null && (RestModel.CODE_SUCCESS ==rest.getCode())  && rest.getData() != null) {
            List<Map<String, Object>> mapList = (List)rest.getData();
            return mapList;
        } else {
            return null;
        }
    }

    public static Boolean isSuccess(RestModel rest) {
        return rest != null && (RestModel.CODE_SUCCESS ==rest.getCode())  && rest.getData() != null;
    }
}
