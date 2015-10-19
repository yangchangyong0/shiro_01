package com.ycy.controller.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**自定义属性编辑器
 * Created by Administrator on 2015/9/24 0024.
 */
public class CustomPropertyEditor implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
        //System.out.println("init binder =======================");
        binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, false));
        binder.registerCustomEditor(Integer.class, null,new CustomNumberEditor(Integer.class, null, true));
        binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
        binder.registerCustomEditor(BigInteger.class, new CustomNumberEditor(BigInteger.class, true));

    }
}
