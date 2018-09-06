package cn.mvp.androidmvp.basemvp1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.mvp.androidmvp.eventbus.EventBusUtil;

/**
 * @author xurunjie 2017/09/04
 */
public abstract class BaseMvpFragment<P extends BasePresenter,M extends BaseModel> extends Fragment implements BaseView {
    /**
     * p层
     */
    protected P presenter;
    /**
     * m层
     */
    protected M model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = ReflectPMUtils.getObject(this,0);
        model = ReflectPMUtils.getObject(this, 1);
        presenter.onAttach(this,model);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
        EventBusUtil.unregister(this);
    }


}