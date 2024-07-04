package `in`.sk.eatscape.adpater

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater

import `in`.sk.eatscape.databinding.MenuItemsBinding

class MenuAdapter(private val menuItemsName: MutableList<String>,
                  private val menuItemPrice: MutableList<String>,
    private val menuImage:MutableList<Int>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menufnp.text = menuItemsName[position]
                menupp.text = menuItemPrice[position]
                menufoodim.setImageResource(menuImage[position])
            }
        }
    }
}
