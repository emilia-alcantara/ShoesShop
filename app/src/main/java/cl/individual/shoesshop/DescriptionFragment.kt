package cl.individual.shoesshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
    private var price: Int = 0

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

        /*binding.imgSelectedShoe.load(imgUrl)
        binding.txtSelectedName.text = name
        binding.txtSelectedPrice.text = "$ " + price.toString()*/

        dataMemory = requireActivity().applicationContext.getSharedPreferences("info compra", Context.MODE_PRIVATE)
        initListeners()
        mostrarDatos()

        return binding.root
    }

    private fun mostrarDatos() {
        binding.imgSelectedShoe.load(imgUrl)
        binding.txtSelectedName.text = name
        binding.txtSelectedPrice.text = "$ " + price.toString()
    }

    private fun initListeners() {
        binding.btnAddToCart.setOnClickListener{
            dataMemory.edit().putString(name, imgUrl)
              /*  .putString("name", name)
                .putString("img", imgUrl)
                .putInt("precio", price)*/
                .apply()
            Log.d("TAG","BOTON ADDDDD TO  CARTTTTT***************")
        //    dataMemory.edit().putString("precio", price.toString()).apply()
/*
*  dataMemory.edit()
        .putString("name", name)
        .putString("imgUrl", imgUrl)
        .putInt("price", price)
        .apply()
*
* */
        }

        binding.btnGoToCart.setOnClickListener{
            findNavController().navigate(R.id.action_descriptionFragment_to_cartFragment)
            Log.d("TAG","BOTON GO TO CARTTTTTTTTTTTTTTTTTTTTTTTTTTT")
        }

        binding.btnDescToHome.setOnClickListener{
            findNavController().navigate(R.id.action_descriptionFragment_to_browseFragment)
        }
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