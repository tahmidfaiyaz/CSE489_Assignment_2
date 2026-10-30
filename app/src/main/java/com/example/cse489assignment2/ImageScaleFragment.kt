package com.example.cse489assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ImageScaleFragment : Fragment() {

    private var scaleFactor = 1.0f
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_image_scale,
            container,
            false
        )

        val imageView =
            view.findViewById<ImageView>(R.id.zoomImage)

        val imageUrl =
            "https://picsum.photos/800/600"

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        scaleGestureDetector =
            ScaleGestureDetector(
                requireContext(),
                object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

                    override fun onScale(
                        detector: ScaleGestureDetector
                    ): Boolean {

                        scaleFactor *= detector.scaleFactor

                        scaleFactor =
                            scaleFactor.coerceIn(0.5f, 4.0f)

                        imageView.scaleX = scaleFactor
                        imageView.scaleY = scaleFactor

                        return true
                    }
                }
            )

        imageView.setOnTouchListener { _, event ->

            scaleGestureDetector.onTouchEvent(event)

            true
        }

        return view
    }
}