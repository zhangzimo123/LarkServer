package com.github.hollykunge.security.common.util;

import com.github.hollykunge.security.common.constant.CommonConstants;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;



/**
 * 实体类相关工具类 
 * 解决问题： 1、快速对实体的常驻字段，如：crtUser、crtHost、updUser等值快速注入
 * 
 * @author dk
 * @version 1.0
 * @date 2018年3月14日
 */
public class EntityUtils {
	/**
	 * 快速将bean的crtUser、crtHost、crtTime、updUser、updHost、updTime附上相关值
	 * 
	 * @param entity 实体bean 
	 * @author dk
	 */
	public static <T> void setCreatAndUpdatInfo(T entity) {
		setCreateInfo(entity);
		setUpdatedInfo(entity);
	}
	
	/**
	 * 快速将bean的crtUser、crtHost、crtTime附上相关值
	 * 
	 * @param entity 实体bean
	 * @author dk
	 */
	public static <T> void setCreateInfo(T entity){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		String pkID = "";
		if(request!=null) {
		    if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERHOST))){
                hostIp = String.valueOf(request.getHeader(CommonConstants.WEB_USERHOST));
            }
            if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERNAME))){
                name = String.valueOf(request.getHeader(CommonConstants.WEB_USERNAME));
            }
            if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERID))){
                id = String.valueOf(request.getHeader(CommonConstants.WEB_USERID));
            }
		}
		pkID = UUIDUtils.generateShortUuid();
		// 默认属性
		String[] fields = {"id","crtName","crtUser","crtHost","crtTime"};
		Field field = ReflectionUtils.getAccessibleField(entity, "crtTime");
		// 默认值
		Object [] value = null;
		if(field!=null&&field.getType().equals(Date.class)){
			value = new Object []{pkID,name,id,hostIp,new Date()};
		}
		// 填充默认属性值
		setDefaultValues(entity, fields, value);
	}

	/**
	 * 快速将bean的updUser、updHost、updTime附上相关值
	 * 
	 * @param entity 实体bean
	 * @author dk
	 */
	public static <T> void setUpdatedInfo(T entity){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(request!=null) {
			if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERHOST))){
				hostIp = String.valueOf(request.getHeader(CommonConstants.WEB_USERHOST));
			}
			if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERNAME))){
				name = String.valueOf(request.getHeader(CommonConstants.WEB_USERNAME));
				name = URLDecoder.decode(name);
			}
			if(!StringUtils.isEmpty(request.getHeader(CommonConstants.WEB_USERID))){
				id = String.valueOf(request.getHeader(CommonConstants.WEB_USERID));
			}
		}
		// 默认属性
		String[] fields = {"updName","updUser","updHost","updTime"};
		Field field = ReflectionUtils.getAccessibleField(entity, "updTime");
		Object [] value = null;
		if(field!=null&&field.getType().equals(Date.class)){
			value = new Object []{name,id,hostIp,new Date()};
		}
		// 填充默认属性值
		setDefaultValues(entity, fields, value);
	}
	/**
	 * 依据对象的属性数组和值数组对对象的属性进行赋值
	 * 
	 * @param entity 对象
	 * @param fields 属性数组
	 * @param value 值数组
	 * @author dk
	 */
	private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
		for(int i=0;i<fields.length;i++){
			String field = fields[i];
			if(ReflectionUtils.hasField(entity, field)){
				ReflectionUtils.invokeSetter(entity, field, value[i]);
			}
		}
	}
	/**
	 * 根据主键属性，判断主键是否值为空
	 * 
	 * @param entity
	 * @param field
	 * @return 主键为空，则返回false；主键有值，返回true
	 * @author dk
	 */
	public static <T> boolean isPKNotNull(T entity,String field){
		if(!ReflectionUtils.hasField(entity, field)) {
			return false;
		}
		Object value = ReflectionUtils.getFieldValue(entity, field);
		return value!=null&&!"".equals(value);
	}
}
