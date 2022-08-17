package ir.MrMohamadHosein.ViewModel_google

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.util.*

class MyLocationListener :ViewModel() {
    private val locationData = MutableLiveData<String>()
    private lateinit var timer :Timer

    init {

        timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {
                    locationData.postValue( System.currentTimeMillis().toString() )
                }
            },
            0L,
            1000L
        )

    }

    fun getLocationData() :LiveData<String> {
        return locationData
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        timer.purge()
    }

}