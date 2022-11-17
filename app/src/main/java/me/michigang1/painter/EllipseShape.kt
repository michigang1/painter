package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

@SuppressLint("ViewConstructor")
class EllipseShape(
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
        val mTempX = 2 * mStartX - mCurrentX
        val mTempY = 2 * mStartY - mCurrentY

        val right = if (mTempX > mCurrentX) mTempX else mCurrentX
        val left = if (mTempX > mCurrentX) mCurrentX else mTempX
        val bottom = if (mTempY > mCurrentY) mCurrentY else mTempY
        val top = if (mTempY > mCurrentY) mTempY else mCurrentY
        canvas.drawOval(left, top, right, bottom, paint)
    }
}
