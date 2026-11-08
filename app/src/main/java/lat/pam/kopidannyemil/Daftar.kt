package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Daftar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar)
        val etNama = findViewById<EditText>(R.id.etNama)
        val etUser = findViewById<EditText>(R.id.etUsername)
        val etPass = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val n = etNama.text.toString().trim()
            val u = etUser.text.toString().trim()
            val p = etPass.text.toString()
            when {
                n.isEmpty() || u.isEmpty() || p.isEmpty() ->
                    Toast.makeText(this, R.string.err_kosong, Toast.LENGTH_SHORT).show()
                p.length < 6 ->
                    Toast.makeText(this, R.string.err_password_pendek, Toast.LENGTH_SHORT).show()
                AppData.users.any { it.username == u } ->
                    Toast.makeText(this, R.string.err_username_ada, Toast.LENGTH_SHORT).show()
                else -> {
                    val user = User(n, u, p)
                    AppData.users.add(user)
                    AppData.currentUser = user
                    Toast.makeText(this, R.string.sukses_daftar, Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(this, MainActivity::class.java).addFlags(
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        )
                    )
                }
            }
        }
    }
}
