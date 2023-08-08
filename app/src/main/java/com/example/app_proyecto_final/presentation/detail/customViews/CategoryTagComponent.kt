package com.example.app_proyecto_final.presentation.detail.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.colorResource
import androidx.core.content.ContextCompat
import com.example.app_proyecto_final.R

class CategoryTagComponent@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val textView: TextView

    init{
        textView = inflate(context, R.layout.category_tag_component_layout, this)
            .findViewById(R.id.categoryTag)
    }

    fun setCategoryText(text: String){
        textView.text = text
    }
}