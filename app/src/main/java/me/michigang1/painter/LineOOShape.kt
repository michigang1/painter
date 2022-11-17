package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*

@SuppressLint("ViewConstructor")
class LineOOShape(
    context: Context,
    strokeColor: Int,
    val fillColor: Int = strokeColor
) : Shape(context, strokeColor, fillColor) {
    constructor(
        context: Context,
        strokeColor: Int,
        fillColor: Int,
        canvas: Canvas
    ) : this(context, strokeColor, fillColor)

    private val line = LineShape(context, strokeColor)
    private val circle1 = CircleShape(context, strokeColor, fillColor)
    private val circle2 = CircleShape(context, strokeColor, fillColor)
    override fun drawShape(canvas: Canvas, paint: Paint) {
        circle1.setCoordinates(mStartX, mStartY, mCurrentX, mCurrentY)
        line.setCoordinates(mStartX, mStartY, mCurrentX, mCurrentY)
        circle2.setCoordinates(mCurrentX, mCurrentY, mCurrentX, mCurrentY)

        if (mStartX != 0f && mStartY != 0f) {
            circle1.drawCircle(canvas, paint)
            line.drawLine(canvas, paint)
            circle2.drawCircle(canvas, paint)
        }
    }
}
