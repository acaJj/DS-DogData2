package sheridan.jaca.dogdata2

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController
import sheridan.jaca.dogdata2.databinding.FragmentInputBinding
import sheridan.jaca.dogdata2.databinding.FragmentOutputBinding
import sheridan.jaca.dogdata2.model.DogData

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding
    private val viewModel: DogDataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater,container,false)

        binding.btnSubmit.setOnClickListener { sendData() }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun sendData() {
        val dogName : String = binding.txtName.text.toString()
        val isTrained: Boolean =binding.chkTrained.isChecked
        val isVaccinated: Boolean = binding.chkVaccinate.isChecked

        if (dogName.isBlank()){
            Toast.makeText(this.context,"Please fill in the textbox.", Toast.LENGTH_LONG).show()
        }else{
            viewModel.send(DogData(dogName,isTrained,isVaccinated))

            goToOutput()
        }
    }

    private fun goToOutput() {
        val action = InputFragmentDirections.actionInputToOutput()
        findNavController().navigate(action)
    }

}