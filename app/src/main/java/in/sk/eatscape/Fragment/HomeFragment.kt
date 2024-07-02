package `in`.sk.eatscape.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import `in`.sk.eatscape.R
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.sk.eatscape.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel
import `in`.sk.eatscape.adpater.PopularAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using ViewBinding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Prepare the list of images for the slideshow
        val imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel(R.drawable.img1, ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.img2, ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.img3, ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.img4, ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.img5, ScaleTypes.FIT))

        // Set up the ImageSlider from binding
        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imgList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imgList[position]

                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodName= listOf("Chicken Tikka","Zaffrani Biryani","Chicken Tawa Masala","Mutton Rogan Josh","Seekh Kabab")
        val Price= listOf("Rs399","Rs299","Rs499","Rs599","Rs349")
        val popularFoodImages= listOf(R.drawable.tikka,R.drawable.bir,R.drawable.ctm,R.drawable.mutt,R.drawable.sk)
        val adapter=PopularAdapter(foodName,Price,popularFoodImages)
        binding.poprv.layoutManager= LinearLayoutManager(requireContext())
        binding.poprv.adapter=adapter


    }
}
