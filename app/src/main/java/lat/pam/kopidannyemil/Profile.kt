package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val etNama = findViewById<EditText>(R.id.etNama)
        etNama.setText(AppData.currentUser?.nama ?: "")
        tvGreeting.text = getString(R.string.halo_format, AppData.namaUser() ?: getString(R.string.tamu))

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val n = etNama.text.toString().trim()
            if (n.isEmpty()) {
                Toast.makeText(this, R.string.err_kosong, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            AppData.currentUser?.nama = n
            tvGreeting.text = getString(R.string.halo_format, n)
            Toast.makeText(this, R.string.profile_tersimpan, Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            AppData.currentUser = null
            AppData.cart.clear()
            startActivity(
                Intent(this, Welcome::class.java).addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            )
        }
        BottomNav.setup(this, 2)
    }
}
