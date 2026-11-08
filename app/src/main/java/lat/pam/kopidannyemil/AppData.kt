package lat.pam.kopidannyemil

data class User(var nama: String, val username: String, val password: String)
data class MenuItem(val id: Int, val foto: Int, val nama: String, val deskripsi: String, val harga: Int)

/** Data statis (dummy) - tanpa database. */
object AppData {
    val users = mutableListOf(User("Pelanggan Demo", "demo", "123456"))
    var currentUser: User? = null
    val cart = mutableMapOf<Int, Int>()

    val menu = listOf(
        MenuItem(1, R.drawable.kopi_susu_gula_aren, "Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000),
        MenuItem(2, R.drawable.donat_coklat, "Donat Cokelat", "Donat empuk, glaze cokelat", 12000),
        MenuItem(3, R.drawable.sourdough_loaf, "Sourdough Loaf", "Roti fermentasi alami", 35000),
        MenuItem(4, R.drawable.cappuccino, "Cappuccino", "Espresso, foam susu lembut", 25000),
        MenuItem(5, R.drawable.matcha_latte, "Matcha Latte", "Matcha Jepang, susu segar", 27000),
        MenuItem(6, R.drawable.croissant_butter, "Croissant Butter", "Renyah berlapis, butter premium", 20000),
        MenuItem(7, R.drawable.es_kopi_karamel, "Es Kopi Karamel", "Cold brew, saus karamel, es", 26000),
        MenuItem(8, R.drawable.tiramisu_slice, "Tiramisu Slice", "Mascarpone, kopi, kakao", 30000)
    )

    fun rupiah(n: Int) = "Rp " + String.format("%,d", n).replace(',', '.')
    fun cartCount() = cart.values.sum()
    fun cartTotal() = cart.entries.sumOf { (id, q) -> (menu.first { it.id == id }.harga) * q }
    fun namaUser() = currentUser?.nama?.takeIf { it.isNotBlank() }
}
