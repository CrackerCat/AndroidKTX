package com.lxj.androidktxdemo.fragment

import android.graphics.Color
import android.widget.TextView
import com.lxj.androidktx.core.*
import com.lxj.androidktxdemo.R
import kotlinx.android.synthetic.main.fragment_recyclerview_ext.*


class RecyclerViewExtDemo : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_recyclerview_ext
    }

    lateinit var data: ArrayList<String>
    override fun initView() {
        super.initView()
        data = arrayListOf<String>().apply {
            for (i in 0..30) {
                add("$i")
            }
        }
        val header = TextView(context).apply {
            text = "我是header"
            setPadding(120,120,120,120)
            click { toast(this.text) }
        }
        val footer = TextView(context).apply {
            text = "我是footer"
            setPadding(120,120,120,120)
            click { toast(this.text) }
        }

        //notify
        recyclerView.vertical(spanCount = 2)
                .divider(color = Color.parseColor("#aaaaaa"), size = 20)
                .bindData(data, R.layout.adapter_rv) { holder, t, position ->
                    holder.setText(R.id.text, "模拟数据 - $t")
                            .setImageResource(R.id.image, R.mipmap.ic_launcher_round)
                }
//                .multiTypes(data, listOf(HeaderDelegate(), ContentDelegate(), FooterDelegate()))
                .addHeader(header) //必须在bindData之后调用
                .addFooter(footer) //必须在bindData之后调用
                .itemClick<String> { data, holder, position ->
                    toast("click ${data[position]}")
                }

        toast(recyclerView.adapter!!::class.java.simpleName)

    }

//
//    class HeaderDelegate : ItemViewDelegate<String>{
//        override fun bind(holder: ViewHolder, t: String, position: Int) {
//            holder.setText(android.R.id.text1, t)
//        }
//        override fun isForViewType(item: String, position: Int): Boolean {
//            return item == "header"
//        }
//
//        override fun getLayoutId(): Int {
//            return android.R.layout.simple_list_item_1
//        }
//    }
//
//    class ContentDelegate : ItemViewDelegate<String>{
//        override fun bind(holder: ViewHolder, t: String, position: Int) {
//            holder.setText(android.R.id.text1, t)
//        }
//        override fun isForViewType(item: String, position: Int): Boolean {
//            return item != "header" && item != "footer"
//        }
//
//        override fun getLayoutId(): Int {
//            return android.R.layout.simple_list_item_1
//        }
//    }
//
//    class FooterDelegate : ItemViewDelegate<String>{
//        override fun bind(holder: ViewHolder, t: String, position: Int) {
//            holder.setText(android.R.id.text1, t)
//        }
//        override fun isForViewType(item: String, position: Int): Boolean {
//            return item == "footer"
//        }
//
//        override fun getLayoutId(): Int {
//            return android.R.layout.simple_list_item_1
//        }
//    }

}
