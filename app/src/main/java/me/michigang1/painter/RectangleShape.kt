package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

@SuppressLint("ViewConstructor")
class RectangleShape(
    context: Context,
    strokeColor: Int,
    fillColor: Int = Color.TRANSPARENT
) : Shape(context, strokeColor, fillColor) {
    constructor(
        context: Context,
        strokeColor: Int,
        fillColor: Int,
        canvas: Canvas
    ) : this(context, strokeColor, fillColor)

    override fun drawShape(canvas: Canvas, paint: Paint) {
        val right = if (mStartX > mCurrentX) mStartX else mCurrentX
        val left = if (mStartX > mCurrentX) mCurrentX else mStartX
        val bottom = if (mStartY > mCurrentY) mStartY else mCurrentY
        val top = if (mStartY > mCurrentY) mCurrentY else mStartY
        canvas.drawRect(left, top, right, bottom, paint)
    }
    fun drawRect(canvas: Canvas, paint: Paint) = drawShape(canvas, paint)
}
