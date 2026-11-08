package lat.pam.kopidannyemil

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.core.content.ContextCompat

object BottomNav {
    /** active: 0 = Home, 1 = Order, 2 = Profile */
    fun setup(a: Activity, active: Int) {
        val items = listOf(R.id.navHome, R.id.navOrder, R.id.navProfile).map { a.findViewById<TextView>(it) }
        items.forEachIndexed { i, tv ->
            if (i == active) {
                tv?.setBackgroundResource(R.drawable.bg_nav_active)
                tv?.setTextColor(ContextCompat.getColor(a, R.color.white))
            }
        }
        items.getOrNull(0)?.setOnClickListener { if (active != 0) go(a, MainActivity::class.java) }
        items.getOrNull(1)?.setOnClickListener { if (active != 1) go(a, AlamatPengiriman::class.java) }
        items.getOrNull(2)?.setOnClickListener { if (active != 2) go(a, Profile::class.java) }
    }

    private fun go(a: Activity, c: Class<*>) {
        a.startActivity(Intent(a, c).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        if (a !is MainActivity) a.finish()
    }
}
