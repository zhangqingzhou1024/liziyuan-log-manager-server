package com.liziyuan.hope.log.manager.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ModelParser {

    private static final Logger logger = LoggerFactory.getLogger(ModelParser.class);

    public static <T> T parse(Object o, Class<T> clazz) {
        if (o == null || clazz == null) return null;
        T newInst = null;
        try {
            newInst = clazz.newInstance();
            BeanUtils.copyProperties(o, newInst);
        } catch (Exception e) {
            logger.error("转换bean失败，堆栈：", e);
            return newInst;
        }
        return newInst;
    }

    public static <T> List<T> parse(List<?> os, Class<T> clazz) {
        if (os == null || os.isEmpty()) return Collections.emptyList();
        List<T> insts = new ArrayList<>(os.size());
        for (Object o : os) {
            try {
                T newInst = clazz.newInstance();
                BeanUtils.copyProperties(o, newInst);
                insts.add(newInst);
            } catch (Exception e) {
                logger.error("转换bean失败，堆栈：", e);
                return Collections.emptyList();
            }
        }
        return insts;
    }

    public static Map<String, Object> beanToMap(Object o) {
        return BeanMap.create(o);
    }

    public static <T> T mapToBean(Map map, Class<T> clazz) {
        Object o = null;
        try {
            o = clazz.newInstance();
            BeanMap bm = BeanMap.create(o);
            bm.putAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) o;
    }

}
