package cn.mvp.androidmvp.basemvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.mvp.androidmvp.eventbus.EventBusUtil;


/**
 * @author xurunjie 2017/09/04
 * 不用反射获取 m,p 层，是怕用户量级太大，反射返回的对象存在空异常
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    /**
     * p层
     */
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.onAttach(this);
        EventBusUtil.register(this);
    }

    @Override
    protected void onDestroy() {
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
