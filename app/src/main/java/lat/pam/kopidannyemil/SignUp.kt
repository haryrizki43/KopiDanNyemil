package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, Daftar::class.java))
        }
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, Masuk::class.java))
        }
    }
}
