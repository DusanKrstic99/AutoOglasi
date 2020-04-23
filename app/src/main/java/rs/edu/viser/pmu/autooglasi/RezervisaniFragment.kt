package rs.edu.viser.pmu.autooglasi


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_rezervisani.view.*

class RezervisaniFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_rezervisani,container,false)
        val lista_vesti=view.Rezervisani
        lista_vesti.adapter=MojAdapter(view.context)
        return view
    }
    companion object{
        fun newInstance():RezervisaniFragment=RezervisaniFragment()
    }

    private class MojAdapter(context: Context):BaseAdapter(){
        private val mContext:Context=context
        private val lista=OglasLister.oglas
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView:TextView = TextView(mContext)
            textView.textSize= 20F
            val view:View=View(mContext);
            if(lista.get(position).brRez.toInt()>0){
                textView.text= lista[position].naslov + "  Broj rezervacija: " + lista[position].brRez
                textView.setOnClickListener({
                })
                return textView}
            return view
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