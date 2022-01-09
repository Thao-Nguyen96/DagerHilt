package gst.trainingcourse_ex11_thaonx4.daggerhilt.view.fragment


import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse_ex11_thaonx4.daggerhilt.base.BaseFragment
import gst.trainingcourse_ex11_thaonx4.daggerhilt.databinding.FragmentLoginBinding

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    override fun initAction() {
        binding.btnLogin.setOnClickListener {
            navigateToListNoteScreen()
        }
    }

    private fun navigateToListNoteScreen(){
        val action = LoginFragmentDirections.actionLoginFragmentToListNoteFragment()
        findNavController().navigate(action)
    }
}