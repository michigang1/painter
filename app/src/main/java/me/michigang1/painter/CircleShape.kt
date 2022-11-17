package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

@SuppressLint("ViewConstructor")
class CircleShape(
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
        val centerX = mStartX
        val centerY = mStartY
        val radius = TOUCH_STROKE_WIDTH
        canvas.drawCircle(centerX, centerY, radius, paint)
    }
    fun drawCircle(canvas: Canvas, paint: Paint) = drawShape(canvas, paint)
}
