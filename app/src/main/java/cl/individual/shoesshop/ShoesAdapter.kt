package cl.individual.shoesshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.individual.shoesshop.databinding.ItemBinding
import coil.load

class ShoesAdapter: RecyclerView.Adapter<ShoesAdapter.MyViewHolder>() {
    var shoeList = mutableListOf<Shoes>()
    private lateinit var binding: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = shoeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val shoe: Shoes = shoeList[position]
        holder.bind(shoe)

    }

    fun setData(shoes: List<Shoes>) {
        this.shoeList = shoes.toMutableList()
    }

    inner class MyViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(shoe: Shoes) {
            binding.imgShoe.load(shoe.imgUrl)
            binding.txtShoeName.text = shoe.shoeName
            binding.txtPrice.text = shoe.shoePrice.toString()

        }

        init {
            itemView.setOnClickListener {
                val shoe = shoeList[adapterPosition]
                val selectedBundle :Bundle? = Bundle()
                selectedBundle?.putString("nombre", shoe.shoeName)
                selectedBundle?.putString("url", shoe.imgUrl)
                selectedBundle?.putInt("precio", shoe.shoePrice)

                itemView.findNavController().navigate(R.id.action_browseFragment_to_descriptionFragment, selectedBundle)
            }
        }

    }
}