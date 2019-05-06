package com.AbdShammout.UBV;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.AbdShammout.UBV.adapter.AdapterPath;
import com.AbdShammout.UBV.model.PathItem;
import com.AbdShammout.UBV.model.PathItemStyle;

import java.util.ArrayList;

public class BreadcrumbsRecyclerView extends RecyclerView implements OnClickPathItem {

    private AdapterPath adapterPath;
    private ArrayList<PathItem> pathItemsList;
    private OnClickListenerBreadcrumbs onClickListenerBreadcrumbs;

    public BreadcrumbsRecyclerView(@NonNull Context context) {
        super(context);
        initRecyclerViewPath();
    }


    public void setOnClickListenerBreadcrumbs(OnClickListenerBreadcrumbs onClickListenerBreadcrumbs) {
        this.onClickListenerBreadcrumbs = onClickListenerBreadcrumbs;
    }

    private void initRecyclerViewPath(){
        pathItemsList = new ArrayList<>();
        adapterPath = new AdapterPath(getContext(), pathItemsList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        setLayoutManager(linearLayoutManager);
        setHasFixedSize(true);
        setAdapter(adapterPath);
    }

    public void setPathItemStyle(PathItemStyle pathItemStyle){
        adapterPath.setPathItemStyle(pathItemStyle);
    }


    public void addToPath(PathItem pathItem){
        if (pathItemsList == null){
            Log.e("List Error ","cant add pathItem to a null reference");
            return;
        }
        if (adapterPath == null){
            Log.e("adapterPath Error ","cant add pathItem to a null reference");
            return;
        }
        pathItemsList.add(pathItem);
        if (pathItemsList.size()==1){
            adapterPath.notifyDataSetChanged();
        } else{
            adapterPath.notifyItemInserted(adapterPath.getItemCount());
            adapterPath.notifyItemChanged(adapterPath.getItemCount()-2);
        }
        post(new Runnable() {
            @Override
            public void run() {
                if (getLayoutManager() != null)
                    getLayoutManager().scrollToPosition(adapterPath.getItemCount() - 1);
            }
        });
    }

    public void addToPath(PathItem pathItem, int position){
        if (pathItemsList == null){
            Log.e("List Error ","cant add pathItem to a null reference");
            return;
        }
        if (adapterPath == null){
            Log.e("adapterPath Error ","cant add pathItem to a null reference");
            return;
        }
        if (position> pathItemsList.size()){
            Log.e("List Error ","cant add pathItem to a size list: "+pathItemsList.size());
            return;
        }
        pathItemsList.add(position, pathItem);
        if (pathItemsList.size()==1){
            adapterPath.notifyDataSetChanged();
        } else{
            adapterPath.notifyItemInserted(position);
            adapterPath.notifyItemRangeChanged(position-1,getItemCount()-1);
            //adapterPath.notifyItemChanged(position-1);
            //adapterPath.notifyItemChanged(adapterPath.getItemCount()-2);
        }
        post(new Runnable() {
            @Override
            public void run() {
                if (getLayoutManager() != null)
                    getLayoutManager().scrollToPosition(adapterPath.getItemCount() - 1);
            }
        });
    }

    public void back(){
        if (pathItemsList.isEmpty())
            return;
        adapterPath.notifyItemRemoved(pathItemsList.size()-1);
        pathItemsList.remove(pathItemsList.size()-1);
        adapterPath.notifyItemChanged(pathItemsList.size()-1);
    }

    public void backTo(int position){
        int levelBack = (adapterPath.getItemCount()-1) - position;
        for (int i = 0; i <levelBack ; i++)
            back();
    }

    public int getItemCount(){
        return adapterPath.getItemCount();
    }


    @Override
    public void onClick(int index, String title, int id) {
        if (onClickListenerBreadcrumbs !=null){
            backTo(index);
            onClickListenerBreadcrumbs.onPathItemClick(index, title, id);
        }
    }

    @Override
    public void onLongClick(int index, String title, int id) {
        if (onClickListenerBreadcrumbs !=null)
            onClickListenerBreadcrumbs.onPathItemLongClick(index, title, id);
    }
}
