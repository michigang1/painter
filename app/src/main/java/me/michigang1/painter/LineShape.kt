package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.abs

@SuppressLint("ViewConstructor")
class LineShape(
    context: Context,
    strokeColor: Int
) : Shape(context, strokeColor) {
    constructor(
        context: Context,
        strokeColor: Int,
        canvas: Canvas
    ) : this(context, strokeColor)

    override fun drawShape(canvas: Canvas, paint: Paint) {
        val dx = abs(mCurrentX - mStartX)
        val dy = abs(mCurrentY - mStartY)
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            canvas.drawLine(mStartX, mStartY, mCurrentX, mCurrentY, paint)
        }
    }

    fun drawLine(canvas: Canvas, paint: Paint) = drawShape(canvas, paint)
}
