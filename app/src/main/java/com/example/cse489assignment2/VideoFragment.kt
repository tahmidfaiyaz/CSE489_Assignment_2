package com.example.cse489assignment2

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment

class VideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_video,
            container,
            false
        )

        val videoView =
            view.findViewById<VideoView>(R.id.videoView)

        val videoUri = Uri.parse(
            "android.resource://${requireContext().packageName}/${R.raw.sample_video}"
        )

        videoView.setVideoURI(videoUri)

        val mediaController =
            MediaController(requireContext())

        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)

        videoView.start()

        return view
    }
}