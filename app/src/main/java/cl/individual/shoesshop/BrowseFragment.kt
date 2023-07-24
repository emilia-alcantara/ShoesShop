package cl.individual.shoesshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.individual.shoesshop.databinding.ActivityMainBinding.inflate
import cl.individual.shoesshop.databinding.FragmentBrowseBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BrowseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BrowseFragment : Fragment() {
    private lateinit var binding: FragmentBrowseBinding
   // private var data: List<Shoes> = getData()

 /*   private fun getData(): List<Shoes> {
        return mutableListOf<Shoes>(
            Shoes(
                "zapatilla 1",
                25000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPF_2iTsYmdkInNjcjkIvcrJyowJPHh89pKQ&usqp=CAU"
            ),
            Shoes(
                "zapatilla 2",
                30000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9pLrEwQZzrQuDNF-Szzz59RO8BzW9ImAUNA&usqp=CAU"
            ),
            Shoes(
                "z3",
                35000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-UfMVO-4i9R-KFOEYTZrbnVIZtCKgnxX0w&usqp=CAU"
            ),
            Shoes(
                "z4",
                29990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFVev0TczYU_YTJinkuEJwqk6nsw4QKPf5rQ&usqp=CAU"
            ),
            Shoes(
                "z5",
                44000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9BhVyJNJM61to9XGJJBGkGyANKY2kwAEgBA&usqp=CAU"
            ),
            Shoes(
                "z6",
                15000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4c1Ci6ug9PFwd4fIEhW5IAwr4FmDlEY3y5g&usqp=CAU"
            ),
            Shoes(
                "z7",
                20000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNk14nYQHUd-BzG5Eb7Bm9NT4UXa3Y0Ji7TyfUbhL_u9CVy-Gja7gmAwcQv07p84zpHic&usqp=CAU"
            ),
            Shoes(
                "z8",
                17000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAhv2XXcCPXzVjAzctu8HjSsWW6Zws0YZWFQ&usqp=CAU"
            ),
            Shoes(
                "z9",
                50000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyfiFsI0r_HHgxlmrR5OIFRCwecgrkVXFYxQ&usqp=CAU"
            ),
            Shoes(
                "z10",
                64000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8Cgw7aR-_kLh2MslsC_uKREUFx9n7qxtOuA&usqp=CAU"
            )
        )
    }*/
    //  private lateinit var presenter: IVPresenter.Presenter


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
        binding = FragmentBrowseBinding.inflate(inflater, container, false)
        //  presenter = BrowsePresenter(this)
        //    presenter.entregarLista()
        goToCart()
        var shoesAdapter = ShoesAdapter()
        val shoeList = Shoes.getShoeList()
        shoesAdapter.setData(shoeList)

        binding.recShoesList.adapter = shoesAdapter


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BrowseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BrowseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun goToCart() {
        binding.btnBrowseCart.setOnClickListener {
            findNavController().navigate(R.id.action_browseFragment_to_cartFragment)
        }
    }

    /*   override fun showShoeList(shoes: List<Shoes>) {
           var shoesAdapter = ShoesAdapter()
           shoesAdapter.setData(shoes)

           binding.recShoesList.adapter = shoesAdapter
       }*/


}


























