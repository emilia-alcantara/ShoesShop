package cl.individual.shoesshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.shoesshop.databinding.ItemCarritoBinding
import coil.load

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    var cartShoeList = mutableListOf<Shoes>()
    private lateinit var binding: ItemCarritoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartShoeList.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart : Shoes = cartShoeList[position]
        holder.bind(cart)
    }

    fun setData(cartShoeList: MutableList<Shoes>) {
        this.cartShoeList = cartShoeList.toMutableList()
    }

    class CartViewHolder(val binding: ItemCarritoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cart: Shoes) {
            binding.imgShoe.load(cart.imgUrl)
            binding.txtShoeName.text = cart.shoeName
            binding.txtPrice.text = "$ " + cart.shoePrice.toString()

        }

    }
}