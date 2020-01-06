package com.cc1500.web.utils;
 
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * 重写了SimplePropertyPreFilter,可以自定义,筛选返回json参数
 */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?>    clazz;
    private final Set<String> includes = new HashSet<String>();
    private final Set<String> excludes = new HashSet<String>();
 
    public SimplePropertyPreFilter(String... properties){
        this(null, properties);
    }
 
    public SimplePropertyPreFilter(Class<?> clazz, String... properties){
        super();
        this.clazz = clazz;
        for (String item : properties) {
            if (item != null) {
                this.excludes.add(item);
            }
        }
    }
 
    public Class<?> getClazz() {
        return clazz;
    }
 
    public Set<String> getIncludes() {
        return includes;
    }
 
    public Set<String> getExcludes() {
        return excludes;
    }
 
    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (source == null) {
            return true;
        }
 
        if (clazz != null && !clazz.isInstance(source)) {
            return true;
        }
 
        if (this.excludes.contains(name)) {
            return false;
        }
 
        if (includes.size() == 0 || includes.contains(name)) {
            return true;
        }
 
        return false;
    }

    public  static String excludeJson(Object object,String...strings){
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(strings);
        return  JSONObject.toJSONString(object,filter);
    }
 
}
