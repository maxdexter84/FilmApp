package ru.maxdexter.filmapp.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.maxdexter.filmapp.R

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun ImageView.setImage(uri: String) {
    Glide.with(this.context)
        .load(uri)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_brocken_img)
        )
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true).into(this)
}