package rs.edu.viser.pmu.autooglasi

class Oglas(val naslov:String, val tekst:String, val cena:Double, var brRez:Int, val auto:Automobil) {
    fun PovecajRezervacije(){
        this.brRez++
    }
}