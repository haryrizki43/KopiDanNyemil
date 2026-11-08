package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlamatPengiriman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pengiriman_alamat)
        val etNama = findViewById<EditText>(R.id.etNama)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        etNama.setText(AppData.currentUser?.nama ?: "")

        val ringkasan = if (AppData.cart.isEmpty()) getString(R.string.keranjang_kosong)
        else AppData.cart.entries.joinToString("\n") { (id, q) ->
            val m = AppData.menu.first { it.id == id }
            "${m.nama} x$q — ${AppData.rupiah(m.harga * q)}"
        }
        findViewById<TextView>(R.id.tvRingkasan).text = ringkasan
        findViewById<TextView>(R.id.tvTotal).text = getString(R.string.total_format, AppData.rupiah(AppData.cartTotal()))

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            when {
                AppData.cart.isEmpty() -> Toast.makeText(this, R.string.err_keranjang, Toast.LENGTH_SHORT).show()
                etNama.text.isBlank() || etAlamat.text.isBlank() ->
                    Toast.makeText(this, R.string.err_alamat, Toast.LENGTH_SHORT).show()
                else -> {
                    startActivity(Intent(this, KonfirmasiPesanan::class.java))
                    finish()
                }
            }
        }
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
            finish()
        }
    }
}
