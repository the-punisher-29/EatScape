package `in`.sk.eatscape.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import `in`.sk.eatscape.R
import `in`.sk.eatscape.adpater.MenuAdapter
import `in`.sk.eatscape.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val orgmenuFoodName = listOf(
        "Chicken Tikka", "Zaffrani Biryani", "Chicken Tawa Masala", "Mutton Rogan Josh", "Seekh Kabab",
        "Fish Amritsari", "Prawn Curry", "Paneer Butter Masala", "Chicken Curry", "Mutton Curry",
        "Fish Curry", "Vegetable Biryani", "Paneer Tikka", "Chicken Wings", "Mutton Keema",
        "Fish Fry", "Mutton Korma", "Butter Chicken", "Fish Tikka", "Mutton Biryani"
    )

    private val orgmenuItemPrice = listOf(
        "Rs399", "Rs299", "Rs499", "Rs599", "Rs349",
        "Rs450", "Rs550", "Rs350", "Rs400", "Rs600",
        "Rs500", "Rs250", "Rs300", "Rs299", "Rs550",
        "Rs400", "Rs600", "Rs450", "Rs350", "Rs650"
    )

    private val orgmenuImage = listOf(
        R.drawable.tikka, R.drawable.bir, R.drawable.ctm, R.drawable.mutt, R.drawable.sk,
        R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir,
        R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir,
        R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir, R.drawable.bir
    )

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)
        binding.menurv.layoutManager = LinearLayoutManager(requireContext())
        binding.menurv.adapter = adapter

        // Setting up search view
        setupSearchView()

        // Showing menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(orgmenuFoodName)
        filteredMenuItemPrice.addAll(orgmenuItemPrice)
        filteredMenuImage.addAll(orgmenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true // Indicate that the query has been handled
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        orgmenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                    filteredMenuFoodName.add(foodName)
                    filteredMenuItemPrice.add(orgmenuItemPrice[index])
                    filteredMenuImage.add(orgmenuImage[index])

            }
        adapter.notifyDataSetChanged()
      }
    }

    companion object {

    }
}