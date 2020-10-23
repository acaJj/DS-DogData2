package sheridan.jaca.dogdata2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sheridan.jaca.dogdata2.model.DogData

class DogDataViewModel(application:Application) : AndroidViewModel(application) {
    private val data = DogData("",false,false)

    private val _data: MutableLiveData<DogData> = MutableLiveData<DogData>().apply { value = data }

    val getData: LiveData<DogData>
        get() = _data

    fun send(dogData: DogData){
        _data.value = dogData
    }
}