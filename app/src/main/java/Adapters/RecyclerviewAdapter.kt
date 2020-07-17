package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learn.learnandroidwithkotlin.R
import model.RecyclerviewModel

class RecyclerviewAdapter(val dataList:ArrayList<RecyclerviewModel>,val clickListener:(RecyclerviewModel)->Unit):RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_card,parent,false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
        holder.bind(dataList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val languageName=itemview.findViewById(R.id.lang) as TextView
        fun bind(data:RecyclerviewModel,clickListener: (RecyclerviewModel) -> Unit){
            languageName.text=data.languages
            itemView.setOnClickListener{
                clickListener(data)
            }
        }
    }
}