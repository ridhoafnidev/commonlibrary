package com.ridhoafni.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ridhoafni.commons.Logs
import java.lang.reflect.InvocationTargetException

abstract class BaseAdapter<TipeData, ViewHolder: RecyclerView.ViewHolder>(
    private var mLayout: Int,
    private var mViewHolderClass: Class<ViewHolder>,
    var mModelClass: Class<TipeData>,
    private var mData: ArrayList<TipeData>,
    private var menuItemClickListener: View.OnClickListener? = null
) : RecyclerView.Adapter<ViewHolder>() {

    fun addData(data: TipeData){
        mData.add(data)
        notifyItemInserted(itemCount - 1)
    }

    fun addListData(list: List<TipeData>){
        mData.addAll(list)
        notifyDataSetChanged()
    }

    fun insertData(position: Int, data: TipeData){
        mData.add(position, data)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun removeData(position: Int) {
        mData.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun updateData(list: ArrayList<TipeData>) {
        mData = list
        notifyDataSetChanged()
    }

    fun updateItem(position: Int, tipeData: TipeData) {
        mData[position] = tipeData
        notifyDataSetChanged()
    }

    fun getmData(): List<TipeData> {
        return mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mLayout, parent, false) as ViewGroup
        try {
            val constructor = mViewHolderClass.getConstructor(View::class.java)
            return constructor.newInstance(view)
        } catch (e: NoSuchMethodException){
             com.ridhoafni.commons.Logs.log("NoSuchMethodException ${e.message}")
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            com.ridhoafni.commons.Logs.log("IllegalAccessException: ${e.message}")
            throw RuntimeException(e)
        } catch (e: InstantiationException) {
            com.ridhoafni.commons.Logs.log("InstantiationException: ${e.message}")
            throw RuntimeException(e)
        } catch (e: InvocationTargetException) {
            com.ridhoafni.commons.Logs.log("InvocationTargetException: ${e.message}")
            throw RuntimeException(e)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)
        bindView(holder, model, position)
    }

    protected abstract fun bindView(holder: ViewHolder, model: TipeData, position: Int)

    private fun getItem(position: Int): TipeData {
        return mData[position]
    }

    override fun getItemCount() = mData.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
    
}