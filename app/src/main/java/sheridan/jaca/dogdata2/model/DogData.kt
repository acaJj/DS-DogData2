package sheridan.jaca.dogdata2.model

import java.io.Serializable

data class DogData(val name: String, val isTrained: Boolean, val isVaccinated: Boolean):
    Serializable