package com.dilarakiraz.upschooltodoo.ui.dailynotes


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dilarakiraz.upschooltodoo.R
import com.dilarakiraz.upschooltodoo.common.viewBinding
import com.dilarakiraz.upschooltodoo.databinding.FragmentDailyNotesBinding

class DailyNotesFragment : Fragment(R.layout.fragment_daily_notes) {

    private val binding by viewBinding (FragmentDailyNotesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
