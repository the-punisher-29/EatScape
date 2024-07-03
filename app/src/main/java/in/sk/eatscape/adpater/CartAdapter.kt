package `in`.sk.eatscape.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `in`.sk.eatscape.databinding.CartItemBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemPrices: MutableList<String>,
    private val cartImages: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 } // Initialize quantities to 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cfn.text = cartItems[position]
                cin.text = cartItemPrices[position]
                cartImage.setImageResource(cartImages[position])
                ciq.text = quantity.toString()
            }
        }
    }
}
