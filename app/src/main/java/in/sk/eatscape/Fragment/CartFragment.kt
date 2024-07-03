package `in`.sk.eatscape.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.sk.eatscape.R
import `in`.sk.eatscape.adapter.CartAdapter
import `in`.sk.eatscape.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Chicken Tikka", "Zaffrani Biryani", "Chicken Tawa Masala", "Mutton Rogan Josh", "Seekh Kabab")
        val cartItemPrice = listOf("Rs399", "Rs299", "Rs499", "Rs599", "Rs349")

        val cartImage = listOf(R.drawable.tikka, R.drawable.bir, R.drawable.ctm, R.drawable.mutt, R.drawable.sk)

        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartrv.layoutManager = LinearLayoutManager(requireContext())
        binding.cartrv.adapter = adapter

        return binding.root
    }

    companion object {
    }
}
