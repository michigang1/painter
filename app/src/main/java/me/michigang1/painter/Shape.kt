package me.michigang1.painter

import android.content.Context
import android.content.res.Resources
import android.graphics.* // ktlint-disable no-wildcard-imports
import android.graphics.Paint.Style
import android.view.MotionEvent
import android.view.View

abstract class Shape(
    context: Context,
    private val strokeColor: Int = Color.TRANSPARENT,
    private val fillColor: Int = Color.TRANSPARENT,
    private val canvas: Canvas? = Canvas(bitmap)
) : View(context) {
    protected var mStartX = 0f
    protected var mStartY = 0f
    protected var mCurrentX = 0f
    protected var mCurrentY = 0f

    private val paint = Paint().apply {
        isAntiAlias
        isDither
        color = strokeColor
        style = Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = TOUCH_STROKE_WIDTH
    }

    private var startColor = Color.BLACK

    protected abstract fun drawShape(canvas: Canvas, paint: Paint)

    fun setCoordinates(
        x1: Float = mStartX,
        y1: Float = mStartY,
        x2: Float = mCurrentX,
        y2: Float = mCurrentY
    ) {
        this.apply {
            mStartX = x1
            mStartY = y1
            mCurrentX = x2
            mCurrentY = y2
        }
    }

    private fun setPaintShape(
        colorPaint: Int,
        stylePaint: Style,
        pathEffect: Boolean
    ) {
        val pathArr = floatArrayOf(5.5f, 25.5f)
        val phase = 10.5f
        this.paint.color = colorPaint
        this.paint.style = stylePaint
        this.paint.pathEffect = if (pathEffect) DashPathEffect(pathArr, phase) else null
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mCurrentX = event!!.x
        mCurrentY = event.y
        onTouchEventShape(event)
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(bitmap!!, 0f, 0f, null)
        drawShape(canvas!!, paint)
    }

    private fun onTouchEventShape(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
    }

    open fun touchUp() {
        setPaintShape(fillColor, Style.FILL, false)
        drawShape(canvas!!, paint)
        setPaintShape(strokeColor, Style.STROKE, false)
        drawShape(canvas, paint)
        mStartX = 0f
        mStartY = 0f
        mCurrentX = 0f
        mCurrentY = 0f
        invalidate()
    }

    private fun touchMove() {
        invalidate()
    }

    private fun touchStart() {
        setPaintShape(startColor, Style.STROKE, true)
        mStartX = mCurrentX
        mStartY = mCurrentY
        invalidate()
    }

    companion object {
        @JvmStatic
        protected val TOUCH_TOLERANCE = 8f

        @JvmStatic
        protected val TOUCH_STROKE_WIDTH = 10f

        private val width = Resources.getSystem().displayMetrics.widthPixels
        private val height = Resources.getSystem().displayMetrics.heightPixels
        protected val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    }
}
