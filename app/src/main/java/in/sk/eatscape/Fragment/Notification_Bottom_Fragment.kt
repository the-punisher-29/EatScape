package `in`.sk.eatscape.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import `in`.sk.eatscape.R
import `in`.sk.eatscape.adpater.NotificationAdapter
import `in`.sk.eatscape.databinding.FragmentNotificationBottomBinding

class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)
        val notifications= listOf("Your order has been Canceled Successfully","Order has been taken by the rider",
            "Your order has been Delivered Successfully","Congrats Your Order has been Placed ")
        val notificationImages= listOf(R.drawable.sademoji,R.drawable.veh,R.drawable.tick,R.drawable.illustration)
        val adapter=NotificationAdapter(ArrayList(notifications),ArrayList(notificationImages))
        binding.notirv.layoutManager=LinearLayoutManager(requireContext())
        binding.notirv.adapter=adapter
        return binding.root
    }

    companion object {
        // Optional: Add any constants or static methods here
    }
}
