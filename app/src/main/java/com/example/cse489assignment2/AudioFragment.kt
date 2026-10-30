package com.example.cse489assignment2

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AudioFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_audio,
            container,
            false
        )

        val playButton =
            view.findViewById<Button>(R.id.playButton)

        val pauseButton =
            view.findViewById<Button>(R.id.pauseButton)

        val stopButton =
            view.findViewById<Button>(R.id.stopButton)

        mediaPlayer = MediaPlayer.create(
            requireContext(),
            R.raw.sample_audio
        )

        playButton.setOnClickListener {

            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
            }
        }

        pauseButton.setOnClickListener {

            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            }
        }

        stopButton.setOnClickListener {

            mediaPlayer?.stop()

            mediaPlayer = MediaPlayer.create(
                requireContext(),
                R.raw.sample_audio
            )
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        mediaPlayer?.release()
        mediaPlayer = null
    }
}