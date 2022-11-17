package me.michigang1.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("ResourceType")
class DrawingShapeView(context: Context) : View(context) {

    // Shapes
    val rectangleShape = RectangleShape(context, Color.BLACK, Color.BLUE)
    val squareShape = SquareShape(context, Color.BLACK, Color.YELLOW)
    val ellipseShape = EllipseShape(context, Color.BLACK, Color.WHITE)
    val lineShape = LineShape(context, Color.BLACK)
    val pointShape = PointShape(context, Color.GREEN)
    val cubeShape = CubeShape(context, Color.GRAY)
    val lineOOShape = LineOOShape(context, Color.GREEN)

    @SuppressLint("UseSupportActionBar")
    fun <T : Shape> AppCompatActivity.toSelectShape(shapeId: Int, shape: T) {
        val nameOfShape = resources.getString(shapeId)
        val subtitle = "Selected object: $nameOfShape"
        supportActionBar?.subtitle = subtitle
        setContentView(shape)
    }
}
