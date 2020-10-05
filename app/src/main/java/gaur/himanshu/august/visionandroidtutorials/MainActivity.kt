package gaur.himanshu.august.visionandroidtutorials

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list = mutableListOf<String>()
//        list.add("Position 1")
//        list.add("Position 2")
//        list.add("Position 3")
//        list.add("Position 4")
//        list.add("Position 5")
//        list.add("Position 6")
//        list.add("Position 7")
//        list.add("Position 8")
//        list.add("Position 9")
//        list.add("Position 10")

        //        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        val adapter = RecyclerAdapter()
//        adapter.setContentList(list)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recyclerView.adapter = adapter

        val list = mutableListOf<DummyClass>()
        list.add(DummyClass(R.drawable.position_1, "position 1"))
        list.add(DummyClass(R.drawable.position_2, "position 2"))
        list.add(DummyClass(R.drawable.position_3, "position 3"))
        list.add(DummyClass(R.drawable.position_4, "position 4"))
        list.add(DummyClass(R.drawable.position_5, "position 5"))
        list.add(DummyClass(R.drawable.position_6, "position 6"))
        list.add(DummyClass(R.drawable.position_7, "position 7"))
        list.add(DummyClass(R.drawable.position_8, "position 8"))
        list.add(DummyClass(R.drawable.position_9, "position 9"))
        list.add(DummyClass(R.drawable.position_10, "position 10"))


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RecyclerAdapter()
        adapter.setContentList(list)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        val helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.ANIMATION_TYPE_DRAG or ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START,
            0
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val draggedPosition = viewHolder.adapterPosition
                val targetPosition = target.adapterPosition
                Collections.swap(list, draggedPosition, targetPosition)
                adapter.notifyItemMoved(draggedPosition, targetPosition)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }
        })

        helper.attachToRecyclerView(recyclerView)


    }
}