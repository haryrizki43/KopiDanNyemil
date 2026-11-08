package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class KonfirmasiPesanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesanan_konfirmasi)
        findViewById<TextView>(R.id.tvGreeting).text =
            getString(R.string.halo_format, AppData.namaUser() ?: getString(R.string.tamu))
        AppData.cart.clear()
        findViewById<Button>(R.id.btnOke).setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java).addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            )
        }
    }
}
