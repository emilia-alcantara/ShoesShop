package cl.individual.shoesshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.individual.shoesshop.databinding.FragmentDescriptionBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DescriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionBinding
   // private lateinit var cartData: List<Shoes>
    private lateinit var dataMemory: SharedPreferences


    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var imgUrl: String? = null
    private var price: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("nombre")
            imgUrl = it.getString("url")
            price = it.getInt("precio")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
     /*   val name = arguments?.getString("nombre")
        val imgUrl = arguments?.getString("url")
        val price = arguments?.getString("precio")*/

        binding.imgSelectedShoe.load(imgUrl)
        binding.txtSelectedName.text = name
        binding.txtSelectedPrice.text = "$ " + price.toString()

        dataMemory = requireActivity().applicationContext.getSharedPreferences("info compra", Context.MODE_PRIVATE)
        initListeners()


        return binding.root
    }

    private fun initListeners() {
        binding.btnAddToCart.setOnClickListener{
            dataMemory.edit().putString(name, imgUrl).apply()

          //  cartData = getData()
        }

        binding.btnGoToCart.setOnClickListener{
            findNavController().navigate(R.id.action_descriptionFragment_to_cartFragment)
        }
    }
    private fun getData(): List<Shoes> {
        val name = arguments?.getString("nombre") ?: "Default Name"
        val price = arguments?.getString("precio")?.toInt() ?: 0
        val imgUrl = arguments?.getString("url") ?: ""

        return mutableListOf<Shoes>(
            Shoes(name, price, imgUrl)
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DescriptionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}