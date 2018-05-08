package bawei.com.zhangduwei0508login_register_test.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bawei.com.zhangduwei0508login_register_test.R;
import bawei.com.zhangduwei0508login_register_test.modle.GoosListBean;
import bawei.com.zhangduwei0508login_register_test.modle.ModelImpl;
import bawei.com.zhangduwei0508login_register_test.modle.MyAdater;
import bawei.com.zhangduwei0508login_register_test.modle.MyAdater2;
import bawei.com.zhangduwei0508login_register_test.presenter.Presenter;
import bawei.com.zhangduwei0508login_register_test.view.custumview.MySearchView;
import bawei.com.zhangduwei0508login_register_test.view.custumview.XListView;


/**
 * 商品列表页
 */

public class GoodsListActivity extends Activity implements View.OnClickListener,IGoodsListView{

    private XListView listView;
    private GridView gridView;
    private static final String TAG = "GoodsListActivity---";
    private boolean flag = true;
    private ImageView change;
    private TextView sousuo;
    private MySearchView mySearchView;
    private int page = 1;
    private List<GoosListBean.DataBean> data;
    private MyAdater myAdater;
    private MyAdater2 myAdater2;
    private Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_list_layout);
        //初始化界面
        initViews();
        //请求书
        presenter = new Presenter();
        presenter.showGoodsListToView(new ModelImpl(), this);
    }

    private void initViews() {
        sousuo = findViewById(R.id.sousuo);
        mySearchView = findViewById(R.id.mysearch);

        sousuo.setOnClickListener(this);
        change = findViewById(R.id.goodslist_change);
        change.setOnClickListener(this);
        listView = findViewById(R.id.goodslist_listview);
        gridView = findViewById(R.id.goodslist_gridview);
        //设置
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(true);

        listView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {

                page=1;
                presenter.showGoodsListFresh(new ModelImpl(),GoodsListActivity.this);

            }

            @Override
            public void onLoadMore() {

                page++;
                presenter.showGoodsListLoadMore(new ModelImpl(),GoodsListActivity.this);
            }
        });

        //条目点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String detailUrl = GoodsListActivity.this.data.get(i-1).getDetailUrl();

                Intent intent = new Intent(GoodsListActivity.this, DetailActivity.class);

                intent.putExtra("url",detailUrl);
                startActivity(intent);
            }
        });
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goodslist_change:
                if (flag) {
                    change.setImageResource(R.drawable.lv_icon);
                    gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    change.setImageResource(R.drawable.grid_icon);
                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }
                flag = !flag;
                break;
            case R.id.sousuo:

                presenter.showGoodsListSousuo(new ModelImpl(),GoodsListActivity.this);
                break;
        }
    }

    //展示商品列表的方法
    @Override
    public void showGoodsList(List<GoosListBean.DataBean> data) {
        this.data=data;
        Log.d(TAG, "showGoodsList: " + data);
        //展示
        myAdater = new MyAdater(GoodsListActivity.this, this.data);
        myAdater2 = new MyAdater2(GoodsListActivity.this, this.data);
        listView.setAdapter(myAdater);

        gridView.setAdapter(myAdater2);
    }

    @Override
    public void showGoodsListFresh(List<GoosListBean.DataBean> data) {
        this.data=data;
        myAdater.notifyDataSetChanged();
        myAdater2.notifyDataSetChanged();
        listView.stopRefresh();

    }

    @Override
    public void showGoodsListLoadMore(List<GoosListBean.DataBean> data) {
        this.data.addAll(data);
        myAdater = new MyAdater(GoodsListActivity.this, this.data);
        myAdater2 = new MyAdater2(GoodsListActivity.this, this.data);
        listView.setAdapter(myAdater);

        gridView.setAdapter(myAdater2);
        listView.stopLoadMore();
    }

    @Override
    public String getContent() {
        return mySearchView.getContent();
    }

    //页数
    @Override
    public String getPage() {
        return page+"";
    }

    @Override
    public void showGoodsListSousuo(List<GoosListBean.DataBean> data) {

        this.data= data;
        myAdater = new MyAdater(GoodsListActivity.this, this.data);
        myAdater2 = new MyAdater2(GoodsListActivity.this, this.data);
        listView.setAdapter(myAdater);

        gridView.setAdapter(myAdater2);

    }


}
