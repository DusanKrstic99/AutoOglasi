package rs.edu.viser.pmu.autooglasi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_oglasi.view.*


class OglasiFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_oglasi,container,false)
        val lista_vesti=view.lista_oglasa
        lista_vesti.adapter=MojAdapter(view.context)
        return view
    }
    companion object{
        fun newInstance():OglasiFragment=OglasiFragment()
    }

    private class MojAdapter(context: Context):BaseAdapter(){
        private var mContext:Context=context

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView:TextView= TextView(mContext)
            textView.setText(OglasLister.oglas.get(position).naslov)
            textView.textSize= 20F
            textView.setOnClickListener({
                val intent=Intent(mContext.applicationContext,PrikazJednog::class.java)
                intent.putExtra("naslov", OglasLister.oglas.get(position).naslov)
                intent.putExtra("tekst", OglasLister.oglas.get(position).tekst)
                intent.putExtra("cena", OglasLister.oglas.get(position).cena.toString())
                intent.putExtra("brRez", OglasLister.oglas.get(position).brRez.toString())
                intent.putExtra("marka", OglasLister.oglas.get(position).auto.marka)
                intent.putExtra("godiste", OglasLister.oglas.get(position).auto.godiste.toString())
                intent.putExtra("Kubikaza", OglasLister.oglas.get(position).auto.kubikaza.toString())
                mContext.startActivity(intent)

            })

            return textView
        }


        override fun getItem(position: Int): Any {
            return OglasLister.oglas.get(position)
        }

        override fun getItemId(position: Int): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            return OglasLister.oglas.size
        }

    }

}
