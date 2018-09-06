package cn.mvp.androidmvp.basemvp;


import java.lang.ref.WeakReference;

import cn.mvp.androidmvp.eventbus.BaseEvent;

/**
 * @param <M> m层
 * @param <V> v层
 * @author xurunjie 2017/09/04
 */
public abstract class BasePresenter<M, V> {
    /**
     * m层
     */
    protected M model;
    /**
     * v层。由于v层比较庞大，逻辑比较复杂，防止内存泄漏
     */
    protected WeakReference<V> view;

    /**
     * @param view v层
     */
    protected void onAttach(V view) {
        this.model = createModel();
        this.view = new WeakReference<>(view);
    }

    /**
     * 获取 v层
     *
     * @return v层
     */
    protected V getView() {
        return isViewAttached() ? view.get() : null;
    }

    /**
     * 获取 m层
     *
     * @return m层
     */
    protected M getModel() {
        if (model == null) {
            model = createModel();
        }
        return model;
    }

    /**
     * 判断v层是否销毁
     *
     * @return v层是否销毁
     */
    protected boolean isViewAttached() {
        return null != view && null != view.get();
    }

    /**
     * 注销 m层 v层
     */
    protected void onDetach() {
        if (null != model) {
            view.clear();
            view = null;
            model = null;
        }
    }

    /**
     * 创建m层
     *
     * @return m层
     */
    protected abstract M createModel();

    /**
     * 接受网络回调事件
     *
     * @param event 回调事件
     */
    public void onEventReceived(BaseEvent event) {
        if (event == null) {
            return;
        }
    }
}
