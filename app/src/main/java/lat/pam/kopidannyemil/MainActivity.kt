package lat.pam.kopidannyemil

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** Halaman Home - daftar makanan & minuman. */
class MainActivity : AppCompatActivity() {
    private lateinit var tvCart: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nama = AppData.namaUser() ?: getString(R.string.tamu)
        findViewById<TextView>(R.id.tvGreeting).text = getString(R.string.halo_format, nama)
        tvCart = findViewById(R.id.tvCart)

        findViewById<RecyclerView>(R.id.rvMenu).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MenuAdapter(AppData.menu) { updateCart() }
        }
        BottomNav.setup(this, 0)
        updateCart()
    }

    override fun onResume() {
        super.onResume()
        updateCart()
    }

    private fun updateCart() {
        tvCart.text = if (AppData.cartCount() == 0) getString(R.string.keranjang_kosong)
        else getString(R.string.keranjang_format, AppData.cartCount(), AppData.rupiah(AppData.cartTotal()))
    }
}
