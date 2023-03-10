package com.pronunu.mysololife.board

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.pronunu.mysololife.R
import com.pronunu.mysololife.utils.FBAuth
import org.w3c.dom.Text

class BoardListViewAdapter(val boardList : MutableList<BoardModel>) : BaseAdapter(){
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
//        if (view == null){

        view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent, false)

//        }

        val itemViewLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemView)
        val title = view?.findViewById<TextView>(R.id.titleArea)
        val content = view?.findViewById<TextView>(R.id.contentArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

        if (boardList[position].uid.equals(FBAuth.getUid())){
            itemViewLinearLayoutView?.setBackgroundColor(Color.parseColor("#ffa500"))
        }

        title!!.text  = boardList[position].title
        content!!.text = boardList[position].content
        time!!.text = boardList[position].time

        return view!!
    }
}