package cl.individual.shoesshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
class CartFragment : Fragment() {
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
        dataMemory = requireActivity().applicationContext.getSharedPreferences("info compra", Context.MODE_PRIVATE)
        initListeners()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val cartAdapter = CartAdapter()
        val cartData = getData()
        cartAdapter.setData(cartData)

        binding.recCart.adapter = cartAdapter
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

    /*    val zapatos = ZapatoVenta.zapatos
        val carrito = mutableListOf<Zapato>()
        val nombres = mSharedPreferences.all

        for (z in zapatos)
        {
            if (nombres.containsKey(z.nombre))carrito.add(z)
        }

        return carrito*/

        return cart
    }

    private fun initListeners() {
        binding.btnFinalizar.setOnClickListener{
            Toast.makeText(context, getString(R.string.mensaje_final), Toast.LENGTH_LONG).show()
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