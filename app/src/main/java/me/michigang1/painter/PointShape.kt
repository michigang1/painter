package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint

@SuppressLint("ViewConstructor")
class PointShape(
    context: Context,
    strokeColor: Int
) : Shape(context, strokeColor) {
    constructor(
        context: Context,
        strokeColor: Int,
        canvas: Canvas
    ) : this(context, strokeColor)

    override fun drawShape(canvas: Canvas, paint: Paint) {
        canvas.drawPoint(mStartX, mStartY, paint)
    }
}
