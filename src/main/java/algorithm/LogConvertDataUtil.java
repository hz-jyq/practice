package algorithm;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author jyq
 * @date
 */
class LogConvertDataUtil {

    /**
     * 获取修改的备注信息
     * @param object
     * @param target
     * @return
     */
    static String   getUpdateLogRemarks(Object object, Object target){
        if(object == null || target == null){
            return  null;
        }
        StringBuilder sb = new StringBuilder();
        //获取原来的数据
        Field[] objects =  ReflectUtil.getFields(object.getClass());
        for (int i = 0; i < objects.length; i++) {

            Field obField = objects[i];
            Object obVal = null,taVal = null;
            obField.setAccessible(true);
            Field tarFiled =  ReflectUtil.getField(target.getClass(),obField.getName());
            LogRemarks logRemarks = tarFiled.getAnnotation(LogRemarks.class);

            if(logRemarks == null){
                continue;
            }
            tarFiled.setAccessible(true);
            try {
                obVal = obField.get(object);
                taVal = tarFiled.get(target);
            } catch (IllegalAccessException e) {
                
            }
            if (object instanceof Date) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                if(!Objects.equals(sf.format(obVal), sf.format(taVal))){
                //    getLogRemarks(sb,logRemarks,obVal,taVal);
                }
            }else if (!Objects.equals(obVal, taVal))  {
               // getLogRemarks(sb,logRemarks,obVal,taVal);
            }
        }
        return sb.length() > 0 ? sb.toString() : null;
    }

    public static void  getLogRemarks(StringBuffer sb,LogRemarks fields, Object obVal,Object taVal){
        sb.append(fields.name()+ "从" + '"' + obVal + '"' + "更改为" + '"' + taVal + '"').append(";");
    }

    /**
     *获取新增的备注信息
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    static String  getAddLogRemarks(Object object) throws IllegalAccessException {
        if(object == null){
            return  null;
        }
        StringBuffer sb = new StringBuffer();
        Class userCla = (Class) object.getClass();
        //获取原来的数据
        Field[] objects =  ReflectUtil.getFields(object.getClass());
        for (int i = 0; i < objects.length; i++) {
            Field obField = objects[i];
            Object obVal;
            LogRemarks logRemarks = obField.getAnnotation(LogRemarks.class);
            if(logRemarks == null){
                continue;
            }
            obVal = obField.get(object);
            if(obVal != null){
                sb.append(logRemarks.name() + obVal).append(";");
            }
        }
        return sb.length() > 0 ? sb.toString() : null;
    }
}
