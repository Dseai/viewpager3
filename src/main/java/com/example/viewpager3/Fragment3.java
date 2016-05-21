package com.example.viewpager3;

/**
 * Created by Administrator on 2016/5/21.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment3 extends Fragment implements  AdapterView.OnItemClickListener{
    private View view;
    private GridView gridView;
    private SimpleAdapter adapter; //声明简单适配器
    private List<Map<String, Object>> dataList;
    int[] drawable = new int[]{R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock, R.drawable.games_control, R.drawable.messenger, R.drawable.ringtone, R.drawable.settings, R.drawable.speech_balloon, R.drawable.weather, R.drawable.world,R.drawable.map};
    String[] iconName = new String[]{"联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置", "语音", "天气", "浏览器", "地图"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.view1, container, false);
        gridView=(GridView)view.findViewById(R.id.gridView);
        this.dataList = new ArrayList<Map<String,Object>>();
        // 配置简单适配器 1.上下文，2.数据 3.布局文件 4.from map中的键名 5.to 与from相对应的id
        adapter = new SimpleAdapter(getActivity(), this.getData(),R.layout.item, new String[]{"pic", "name"}, new int[]{R.id.pic, R.id.name});
        gridView.setAdapter(adapter); //执行适配器
        gridView.setOnItemClickListener(this); //注意使用的是OnItemClickListener监听器
        return view;
    }
    private List<Map<String, Object>> getData() {
        //配置资源信息，1.图片资源，放置一个数组内2.文本资源放在一个数组内
        for(int i = 0; i < drawable.length; ++i) {
            HashMap map = new HashMap();//新建hashmap
            map.put("pic", drawable[i]);//填充第一个图片部分
            map.put("name", iconName[i]);//填充第二个文字部分
            this.dataList.add(map);
        }
        Log.i("Main", "size=" + this.dataList.size());
        return this.dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"我是"+ iconName[position],Toast.LENGTH_SHORT).show();
        if(iconName[position]=="浏览器");
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://baidu.com"));
            startActivity(intent);
        }
        if(iconName[position]=="天气");
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.weather.com"));
            startActivity(intent);
        }
        if(iconName[position]=="地图")
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://map.baidu.com"));
            startActivity(intent);
        }
    }


}
