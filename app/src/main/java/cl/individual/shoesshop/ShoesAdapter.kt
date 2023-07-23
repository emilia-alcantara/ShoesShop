package cl.individual.shoesshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.shoesshop.databinding.ItemBinding
import coil.load

class ShoesAdapter: RecyclerView.Adapter<ShoesAdapter.MyViewHolder>() {
    var shoeList = mutableListOf<Shoes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = shoeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val shoe: Shoes = shoeList[position]
        holder.bind(shoe)
        holder.itemView.setOnClickListener{
            // PENDIENTE IMPLEMENTAR
        }


    }

    class MyViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(shoe: Shoes) {
            binding.imgShoe.load(shoe.imgUrl)
            binding.txtShoeName.text = shoe.shoeName
            binding.txtPrice.text = shoe.shoePrice.toString()
        }

    }
}