package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Masuk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.masuk)
        val etUser = findViewById<EditText>(R.id.etUsername)
        val etPass = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val u = etUser.text.toString().trim()
            val p = etPass.text.toString()
            if (u.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, R.string.err_kosong, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = AppData.users.firstOrNull { it.username == u && it.password == p }
            if (user == null) {
                Toast.makeText(this, R.string.err_login, Toast.LENGTH_SHORT).show()
            } else {
                AppData.currentUser = user
                startActivity(
                    Intent(this, MainActivity::class.java).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    )
                )
            }
        }
        findViewById<TextView>(R.id.tvToRegister).setOnClickListener {
            startActivity(Intent(this, Daftar::class.java))
            finish()
        }
    }
}
