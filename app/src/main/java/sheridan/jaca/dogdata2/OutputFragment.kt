package sheridan.jaca.dogdata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import sheridan.jaca.dogdata2.databinding.FragmentOutputBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OutputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding
    private val viewModel: DogDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater,container,false)

        binding.btnBack.setOnClickListener { goBack() }
        binding.lifecycleOwner = viewLifecycleOwner
        binding.dogData = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun goBack() {
        val action = OutputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }

}