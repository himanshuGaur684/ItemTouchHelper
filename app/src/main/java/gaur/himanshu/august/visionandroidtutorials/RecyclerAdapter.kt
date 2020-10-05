package gaur.himanshu.august.visionandroidtutorials

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_for_grid_view.view.*
import kotlinx.android.synthetic.main.list_item_for_recycler.view.*

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var list = listOf<DummyClass>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setContentList(list: List<DummyClass>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_for_grid_view, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {

        holder.itemView.list_item_image.setImageResource(list[position].image)
        holder.itemView.list_description.text=list[position].desc


    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}