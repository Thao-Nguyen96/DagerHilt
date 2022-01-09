package gst.trainingcourse_ex11_thaonx4.daggerhilt.view.fragment


import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse_ex11_thaonx4.daggerhilt.base.BaseFragment
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.databinding.FragmentAddNoteBinding
import gst.trainingcourse_ex11_thaonx4.daggerhilt.viewmodel.NoteViewModel

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(
    FragmentAddNoteBinding::inflate
) {

    private val noteViewModel: NoteViewModel by activityViewModels()

    override fun initAction() {
        binding.btnAddNote.setOnClickListener {
            handleAddNote()
            navigateToListNoteScreen()
        }
    }

    private fun handleAddNote() {
        val note = Note(
            title = binding.edtAddNote.text.toString(),
            description = binding.edtDescription.text.toString()
        )

        noteViewModel.insertNote(note)
    }

    private fun navigateToListNoteScreen(){
        val action = AddNoteFragmentDirections.actionAddNoteFragmentToListNoteFragment()
        findNavController().navigate(action)
    }

}