package rs.edu.viser.pmu.autooglasi


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class PrikazJednog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_prikaz_jednog)
        val naslov:String=intent.getStringExtra("naslov")
        val unos:String =naslov
        supportActionBar?.setTitle(unos)

        val tekst:String=intent.getStringExtra("tekst")
        val unos2:String =tekst
        val prikazTeksta:TextView = findViewById(R.id.Tekst)
        prikazTeksta.setText(unos2)

        val cena:String=intent.getStringExtra("cena")
        val unos3:String ="Cena : "+cena
        val prikazCene:TextView = findViewById(R.id.Cena)
        prikazCene.setText(unos3)

        val BrRez:String=intent.getStringExtra("brRez")
        val unos4:String ="Broj rezervacija : "+BrRez
        val prikazBrRez:TextView = findViewById(R.id.BrRez)
        prikazBrRez.setText(unos4)

        val Marka:String=intent.getStringExtra("marka")
        val godiste:String=intent.getStringExtra("godiste")
        val Kubikaza:String=intent.getStringExtra("Kubikaza")
        val Podaci:String = "Marka vozila: " + Marka + "\nGodiste: "+ godiste + "\nKubikaza: " +Kubikaza
        val prikazPodataka:TextView = findViewById(R.id.Podaci)
        prikazPodataka.setText(Podaci)

        val dugme:Button = findViewById(R.id.Rezervisi)
        dugme.setOnClickListener({
            for(Oglas in OglasLister.oglas){
                if(naslov==Oglas.naslov){
                    Oglas.PovecajRezervacije()
                    Toast.makeText(this,"Uspesno rezervisano",Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}