package cl.individual.shoesshop

import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.shoesshop.databinding.ItemCarritoBinding
import coil.load

class CartAdapter(private val dataMemory: SharedPreferences,
                  private val cartFragment: CartFragment) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var cartShoeList = mutableListOf<Shoes>()
    private lateinit var binding: ItemCarritoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartShoeList.size


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart: Shoes = cartShoeList[position]
        holder.bind(cart)
    }


    fun setData(cartShoeList: MutableList<Shoes>) {
        this.cartShoeList = cartShoeList.toMutableList()
        notifyDataSetChanged()
    }

    inner class CartViewHolder(val binding: ItemCarritoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cart: Shoes) {
            binding.imgShoe.load(cart.imgUrl)
            binding.txtShoeName.text = cart.shoeName
            binding.txtPrice.text = "$ ${cart.shoePrice}"

            binding.btnEliminarItem.setOnClickListener {
                val position = adapterPosition
                val itemToRemove = cartShoeList[position]
                dataMemory.edit().remove(itemToRemove.shoeName).apply()
                cartShoeList.removeAt(position)
                notifyItemRemoved(position)
                cartFragment.addPrices(cartShoeList)
            }
        }
    }
}
