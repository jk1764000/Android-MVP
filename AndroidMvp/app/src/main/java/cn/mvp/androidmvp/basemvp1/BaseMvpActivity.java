package cn.mvp.androidmvp.basemvp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.mvp.androidmvp.eventbus.EventBusUtil;


/**
 * @author xurunjie 2017/09/04
 * 反射获取m，p层 使用起来比较简单快捷
 */
public abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity implements BaseView {
    /**
     * p层
     */
    protected P presenter;
    /**
     * m层
     */
    protected M model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = ReflectPMUtils.getObject(this,0);
        model = ReflectPMUtils.getObject(this, 1);
        presenter.onAttach(this,model);
        EventBusUtil.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
        EventBusUtil.unregister(this);
    }

}
