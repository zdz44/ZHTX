package com.example.user.zhtx.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.user.zhtx.pojo.Friend;
import com.example.user.zhtx.pojo.FriendsGPS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by user on 2018/11/23.
 */

public class FriendsGPSList {
    private Context context;

    public FriendsGPSList(Context context){
        this.context = context;
    }

    public ArrayList<FriendsGPS> getAll(){
        SharedPreferences sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        String data = sp.getString("friendsGPS","未找到");
        ArrayList<FriendsGPS> list = null;
        if ("未找到".equals(data)){
            ShowToast.show(context,"从sp获取信息出错");
        }else {
            Gson gson = new Gson();
            list = gson.fromJson(data, new TypeToken<ArrayList<FriendsGPS>>() {}.getType());
            Log.i("getFriendGPS",data+"------------------");
        }
        return  list;
    }

    public ArrayList<FriendsGPS> getcare(){
        ArrayList<FriendsGPS> allList = getAll();
        ArrayList<FriendsGPS> careList = new ArrayList<>();
        for (int i=0;i<allList.size();i++){
            if (allList.get(i).getAttention() == 1){
                careList.add(allList.get(i));
            }
        }
        return careList;
    }

    public ArrayList<FriendsGPS> update(){
        GetGPS getGPS = new GetGPS(context);
        getGPS.getFriendsGps();
        ArrayList<FriendsGPS> list = getAll();
        return list;
    }

}



