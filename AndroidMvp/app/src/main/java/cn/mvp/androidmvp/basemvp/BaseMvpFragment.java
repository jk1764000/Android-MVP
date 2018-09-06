package cn.mvp.androidmvp.basemvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.mvp.androidmvp.eventbus.EventBusUtil;

/**
 * @author xurunjie 2017/09/04
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends Fragment implements BaseView {
    /**
     * p层
     */
    protected P presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = createPresenter();
        presenter.onAttach(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDetach();
        EventBusUtil.unregister(this);
    }

    /**
     * 获取 p层
     *
     * @return p层
     */
    protected P getPresenter() {
        if (presenter == null) {
            presenter = createPresenter();
        }
        return presenter;
    }

    /**
     * 生成 p层
     *
     * @return p层
     */
    protected abstract P createPresenter();
}