package gst.trainingcourse_ex11_thaonx4.daggerhilt.view.fragment


import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse_ex11_thaonx4.daggerhilt.adapter.NoteAdapter
import gst.trainingcourse_ex11_thaonx4.daggerhilt.base.BaseFragment
import gst.trainingcourse_ex11_thaonx4.daggerhilt.databinding.FragmentListNoteBinding
import gst.trainingcourse_ex11_thaonx4.daggerhilt.viewmodel.NoteViewModel

@AndroidEntryPoint
class ListNoteFragment : BaseFragment<FragmentListNoteBinding>(
    FragmentListNoteBinding::inflate
) {

    private val noteViewModel: NoteViewModel by activityViewModels()
    private val noteAdapter = NoteAdapter()

    override fun initAction() {
        binding.btnNotes.setOnClickListener {
            navigateToAddNoteFragment()
        }
    }

    override fun observerLiveData() {
        noteViewModel.notes.observe(this){notes ->
            noteAdapter.differ.submitList(notes)
        }
    }

    override fun initData() {
        noteViewModel.getAll()
    }

    override fun initView() {
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = noteAdapter
    }

    private fun navigateToAddNoteFragment(){
        val action = ListNoteFragmentDirections.actionListNoteFragmentToAddNoteFragment()
        findNavController().navigate(action)
    }


}