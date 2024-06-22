package `in`.sk.eatscape

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.ArrayAdapter
import `in`.sk.eatscape.R
import androidx.core.view.WindowInsetsCompat
import `in`.sk.eatscape.databinding.ActivityChooseLocationBinding
import `in`.sk.eatscape.databinding.ActivityLoginBinding

class ChooseLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val locationList = arrayOf(
            "Admin Block", "Type-B Quarters", "Type-C Quarters",
            "Department Buildings", "Shamiyaana", "Y3 Hostel",
            "G5 Hostel", "B1 Hostel", "I3 Hostel"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView=binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}