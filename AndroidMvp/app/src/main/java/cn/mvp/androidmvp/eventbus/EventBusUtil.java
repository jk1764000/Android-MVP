package cn.mvp.androidmvp.eventbus;


import org.greenrobot.eventbus.EventBus;

/**
 * @author xurunjie 2017/09/04
 */
public class EventBusUtil {
    /**
     * 注册eventbus
     * @param subscriber
     */
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 取消eventbus
     * @param subscriber
     */
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发送eventbus
     * @param event
     */
    public static void sendEvent(BaseEvent event) {
        EventBus.getDefault().post(event);
    }
}
