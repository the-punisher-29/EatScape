package `in`.sk.eatscape.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import `in`.sk.eatscape.R
import `in`.sk.eatscape.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel

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
    }
}
