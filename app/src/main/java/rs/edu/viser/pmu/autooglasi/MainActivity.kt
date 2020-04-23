package rs.edu.viser.pmu.autooglasi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar

    fun openFragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    val mOnNavigationItemSelectedLister= BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when(item.itemId){
            R.id.navigation_oglasi->{
                toolbar.title="Oglasi"
                val vestiFragment=OglasiFragment.newInstance()
                openFragment(vestiFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dodaj_oglas->{
                toolbar.title="Dodaj oglas"
                val dodajVestFragment=DodajOglasFragment.newInstance()
                openFragment(dodajVestFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_rezervisani->{
                toolbar.title="Rezervisani"
                val dodajVestFragment=RezervisaniFragment.newInstance()
                openFragment(dodajVestFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=supportActionBar!!
        val bottomNavigationView:BottomNavigationView=findViewById(R.id.navigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedLister)
        openFragment(OglasiFragment.newInstance())
    }
}
