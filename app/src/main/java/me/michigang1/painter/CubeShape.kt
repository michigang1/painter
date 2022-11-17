package me.michigang1.painter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.abs

@android.annotation.SuppressLint("ViewConstructor")
class CubeShape(
    context: Context,
    strokeColor: Int
) : Shape(context, strokeColor) {
    constructor(
        context: Context,
        strokeColor: Int,
        canvas: Canvas
    ) : this(context, strokeColor)

    private val visibleRect = RectangleShape(context, strokeColor)
    private val invisibleRect = RectangleShape(context, strokeColor)

    private val line1 = LineShape(context, strokeColor)
    private val line2 = LineShape(context, strokeColor)
    private val line3 = LineShape(context, strokeColor)
    private val line4 = LineShape(context, strokeColor)

    override fun drawShape(canvas: Canvas, paint: Paint) {
        val dX = abs(mStartY - mCurrentX) * 0.25f
        val dY = abs(mStartY - mCurrentY) * 0.25f

        visibleRect.setCoordinates(mStartX, mStartY, mCurrentX, mCurrentY)
        invisibleRect.setCoordinates(mStartX + dX, mStartY + dY, mCurrentX + dX, mCurrentY + dY)

        line1.setCoordinates(mStartX, mStartY, mStartX + dX, mStartY + dY)
        line2.setCoordinates(mCurrentX, mCurrentY, mCurrentX + dX, mCurrentY + dY)
        line3.setCoordinates(mStartX, mCurrentY, mStartX + dX, mCurrentY + dY)
        line4.setCoordinates(mCurrentX, mStartY, mCurrentX + dX, mStartY + dY)

        visibleRect.drawRect(canvas, paint)
        line1.drawLine(canvas, paint)
        line2.drawLine(canvas, paint)
        line3.drawLine(canvas, paint)
        line4.drawLine(canvas, paint)
        invisibleRect.drawRect(canvas, paint)
    }
}
