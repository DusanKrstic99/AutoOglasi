package rs.edu.viser.pmu.autooglasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dodaj_vest.*

class DodajOglasFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View= inflater.inflate(R.layout.fragment_dodaj_vest,container,false)
        val dugme:Button=view.findViewById(R.id.dodajVest)
        dugme.setOnClickListener({
            if(Cena.text.toString()==""){
                OglasLister.oglas.add(Oglas(naslovOglasa.text.toString(),textOglasa.text.toString(),0.0,0,auto = Automobil(marka.text.toString(),godite.text.toString().toInt(),Kubikaza.text.toString().toInt())))}
            else{
                OglasLister.oglas.add(Oglas(naslovOglasa.text.toString(),textOglasa.text.toString(),Cena.text.toString().toDouble(),0,auto = Automobil(marka.text.toString(),godite.text.toString().toInt(),Kubikaza.text.toString().toInt())))
            }
            Toast.makeText(view.context,"Uspesno ste dodali oglas",Toast.LENGTH_LONG).show()

        })
        return view
    }

    companion object{
        fun newInstance():DodajOglasFragment=DodajOglasFragment()
    }
}