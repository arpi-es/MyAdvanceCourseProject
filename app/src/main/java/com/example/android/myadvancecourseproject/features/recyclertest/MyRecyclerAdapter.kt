package com.example.android.myadvancecourseproject.features.recyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myadvancecourseproject.R
import kotlinx.android.synthetic.main.list_item.view.*

class MyRecyclerAdapter(val lstItem :ArrayList<String>,val clickHelper: ClickHelper) : RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerHolder {
      val v= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  MyRecyclerHolder(v, clickHelper )
    }

    override fun getItemCount(): Int {
       return lstItem.size
    }

    override fun onBindViewHolder(holder: MyRecyclerHolder, position: Int) {

            holder.onBind(lstItem[position])
    }

    class MyRecyclerHolder(val v:View,val clickHelper: ClickHelper) : RecyclerView.ViewHolder(v){

       fun onBind(item:String){
            v.txtName.text=item
            v.setOnClickListener{
                clickHelper.onClick(item)
            }

        }

    }
}