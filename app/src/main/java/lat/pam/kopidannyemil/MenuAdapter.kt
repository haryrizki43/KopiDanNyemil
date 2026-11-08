package lat.pam.kopidannyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onChanged: () -> Unit
) : RecyclerView.Adapter<MenuAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val foto: ImageView = v.findViewById(R.id.ivMenu)
        val nama: TextView = v.findViewById(R.id.tvNama)
        val desk: TextView = v.findViewById(R.id.tvDesk)
        val harga: TextView = v.findViewById(R.id.tvHarga)
        val add: Button = v.findViewById(R.id.btnAdd)
    }

    override fun onCreateViewHolder(p: ViewGroup, t: Int): VH =
        VH(LayoutInflater.from(p.context).inflate(R.layout.item_menu, p, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(h: VH, pos: Int) {
        val m = items[pos]
        h.foto.setImageResource(m.foto)
        h.foto.contentDescription = m.nama
        h.nama.text = m.nama
        h.desk.text = "• " + m.deskripsi
        h.harga.text = AppData.rupiah(m.harga)
        fun refresh() {
            val q = AppData.cart[m.id] ?: 0
            val ctx = h.itemView.context
            h.add.text = if (q == 0) ctx.getString(R.string.tambah) else ctx.getString(R.string.dipesan_format, q)
        }
        refresh()
        h.add.setOnClickListener {
            AppData.cart[m.id] = (AppData.cart[m.id] ?: 0) + 1
            refresh()
            onChanged()
        }
    }
}
