package `in`.sk.eatscape.adpater

import android.renderscript.ScriptGroup.Binding
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import `in`.sk.eatscape.databinding.NotificationItemBinding
import java.util.ArrayList

class NotificationAdapter(private var notification: ArrayList<String>,private var notificationImage: ArrayList<Int>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding =NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =notification.size

    inner class NotificationViewHolder(private val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notitv.text=notification[position]
                notiim.setImageResource(notificationImage[position])
            }
        }

    }
}
