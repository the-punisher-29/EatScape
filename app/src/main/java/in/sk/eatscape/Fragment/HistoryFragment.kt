package `in`.sk.eatscape.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.sk.eatscape.R
import `in`.sk.eatscape.adapter.BuyAgainAdapter
import `in`.sk.eatscape.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val buyAgainFoodName = listOf(
            "Chicken Tikka", "Chicken Tawa Masala", "Mutton Rogan Josh", "Seekh Kabab",
            "Prawn Curry", "Chicken Curry", "Mutton Curry",
            "Fish Curry", "Mutton Keema", "Mutton Korma", "Butter Chicken"
        )

        val buyAgainFoodPrice = listOf(
            "Rs399", "Rs499", "Rs599", "Rs349",
            "Rs450", "Rs550", "Rs600",
            "Rs300", "Rs299", "Rs550", "Rs650"
        )

        val buyAgainFoodImage = listOf(
            R.drawable.tikka, R.drawable.bir, R.drawable.ctm, R.drawable.mutt, R.drawable.sk,
            R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir,
            R.drawable.bir
        )

        buyAgainAdapter = BuyAgainAdapter(ArrayList(buyAgainFoodName), ArrayList(buyAgainFoodPrice), ArrayList(buyAgainFoodImage))
        binding.buyagainrv.adapter = buyAgainAdapter
        binding.buyagainrv.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        // Optional: Add any constants or static methods here
    }
}
