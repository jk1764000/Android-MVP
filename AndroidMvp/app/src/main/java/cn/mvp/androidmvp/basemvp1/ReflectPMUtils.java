package cn.mvp.androidmvp.basemvp1;

import java.lang.reflect.ParameterizedType;

/**
 * @author xurunjie 2017/09/04
 * 通过反射获取泛型，生成对象
 */
public class ReflectPMUtils {

    public static <T> T getObject(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType)
                    (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
