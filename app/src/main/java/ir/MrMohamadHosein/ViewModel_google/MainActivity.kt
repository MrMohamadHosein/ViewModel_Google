package ir.MrMohamadHosein.ViewModel_google

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myLocationListener = ViewModelProvider(this).get(MyLocationListener::class.java)

        Log.v("testLog" , myLocationListener.getLocationData().value ?: "null")

        myLocationListener.getLocationData().observe(this) {
            Log.v("testLog" , it)
        }

    }


}