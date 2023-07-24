package cl.individual.shoesshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.individual.shoesshop.databinding.FragmentCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment(){
    private lateinit var binding: FragmentCartBinding
    private lateinit var dataMemory: SharedPreferences

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        dataMemory = requireActivity().applicationContext.getSharedPreferences(
            "info compra",
            Context.MODE_PRIVATE
        )
        initListeners()
        initAdapter()
     //   addPrices()

        return binding.root
    }

    private fun vaciarCart() {
            dataMemory.edit().clear().apply()
            findNavController().navigate(R.id.action_cartFragment_self)
        Log.d("TAG", "vaciar carro--------------------------------------")

    }

    public fun addPrices(cartData: List<Shoes>) {
     //   val cartData = getData()
        var totalPrice = 0

        for (shoe in cartData) {
                totalPrice += shoe.shoePrice
        }
        binding.txtTotalCost.text = "$ $totalPrice"
        Log.d("TAG", "SUMA LOS PRECIOS--------------------------------------")

    }

    private fun initAdapter() {
        val cartData = getData()
        val cartAdapter = CartAdapter(dataMemory, this)
        cartAdapter.setData(cartData)
        binding.recCart.adapter = cartAdapter
        Log.d("TAG","INIT ADAPTER ------------------------------------------------")

        updateCartData(cartAdapter)
        Log.d("TAG", "AFTER UPDATE ADAPTER ------------------------------------------")
    }

    private fun updateCartData(adapter: CartAdapter) {
        val cartData = getData()
        adapter.setData(cartData)
        Log.d("TAG", "CREATING THE UPDATE -------------------------------------------")
        addPrices(cartData)
        Log.d("TAG","TRYING TO UPDATE DE COST *********************************************")
    /*val cartData = getData()
        cartAdapter.setData(cartData)
        addPrices(cartData)
        * */
    }

    private fun getData(): MutableList<Shoes> {
        val shoes = Shoes.getShoeList()
        val cart = mutableListOf<Shoes>()
        val shoesInCart = dataMemory.all

        for (s in shoes) {
            if (shoesInCart.containsKey(s.shoeName)) {
                cart.add(s)
            }
        }

        return cart
    }

    private fun initListeners() {
        binding.btnFinalizar.setOnClickListener {
            Toast.makeText(context, getString(R.string.mensaje_final), Toast.LENGTH_LONG).show()
        }

        binding.btnVaciar.setOnClickListener{
            vaciarCart()
            Log.d("TAG","BOTON VACIARRRRRRRRRRR**************************")
        }

        binding.btnCartToHome.setOnClickListener{
            findNavController().navigate(R.id.action_cartFragment_to_browseFragment)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}