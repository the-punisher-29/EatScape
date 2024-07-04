package `in`.sk.eatscape

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import `in`.sk.eatscape.adpater.MenuAdapter
import `in`.sk.eatscape.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.bb.setOnClickListener{
            dismiss()
        }

        val menuFoodName = listOf(
            "Chicken Tikka", "Zaffrani Biryani", "Chicken Tawa Masala", "Mutton Rogan Josh", "Seekh Kabab",
            "Fish Amritsari", "Prawn Curry", "Paneer Butter Masala", "Chicken Curry", "Mutton Curry",
            "Fish Curry", "Vegetable Biryani", "Paneer Tikka", "Chicken Wings", "Mutton Keema",
            "Fish Fry", "Mutton Korma", "Butter Chicken", "Fish Tikka", "Mutton Biryani"
        )

        val menuItemPrice = listOf(
            "Rs399", "Rs299", "Rs499", "Rs599", "Rs349",
            "Rs450", "Rs550", "Rs350", "Rs400", "Rs600",
            "Rs500", "Rs250", "Rs300", "Rs299", "Rs550",
            "Rs400", "Rs600", "Rs450", "Rs350", "Rs650"
        )

        val menuImage = listOf(
            R.drawable.tikka, R.drawable.bir, R.drawable.ctm, R.drawable.mutt, R.drawable.sk,
            R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir,
            R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir,
            R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir
        )

        val adapter = MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.menurv.layoutManager = LinearLayoutManager(requireContext())
        binding.menurv.adapter = adapter

        return binding.root
    }

    companion object {

    }
}
