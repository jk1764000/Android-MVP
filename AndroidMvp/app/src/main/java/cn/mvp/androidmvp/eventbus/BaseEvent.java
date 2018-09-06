package cn.mvp.androidmvp.eventbus;

/**
 * @author xurunjie 2017/09/04
 */
public class BaseEvent<T> {
    private int code;
    private T data;

    /**
     * event接受标识
     *
     * @param code 接受标识
     */
    public BaseEvent(int code) {
        this.code = code;
    }

    /**
     * event接受标识和数据
     *
     * @param code 接受标识
     * @param data 数据
     */
    public BaseEvent(int code, T data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 获取标识
     *
     * @return 获取标识
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置标识
     *
     * @return 设置标识
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取数据
     *
     * @return 获取数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置数据
     *
     * @return 设置数据
     */
    public void setData(T data) {
        this.data = data;
    }
}