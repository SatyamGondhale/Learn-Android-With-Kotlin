package Adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.learn.learnandroidwithkotlin.R
import kotlinx.android.synthetic.main._list_view.view.*
import model.ListViewModel


class ListViewAdapter(val context:Activity,val list:List<ListViewModel>) : ArrayAdapter<String>(context,
    R.layout.custom_listview){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater=context.layoutInflater
        val rowView=inflater.inflate(R.layout.custom_listview,parent,false)
        val langTitle=rowView.findViewById(R.id.lang_name)as TextView
        val langImage=rowView.findViewById(R.id.lang_image) as ImageView
        var data:ListViewModel=list[position]
        langTitle.text=data.lang
        langImage.setImageResource(data.imgId)
        return rowView
    }

    override fun getCount(): Int {
        return list.size
    }
}
