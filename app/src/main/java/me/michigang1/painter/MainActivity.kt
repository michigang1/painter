package me.michigang1.painter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var drawingShapeView: DrawingShapeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawingShapeView = DrawingShapeView(this)
        setContentView(drawingShapeView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawingShapeView.apply {
            when (item.itemId) {
                R.id.action_line -> toSelectShape(R.string.action_line, lineShape)
                R.id.action_point -> toSelectShape(R.string.action_point, pointShape)
                R.id.action_rectangle -> toSelectShape(R.string.action_rectangle, rectangleShape)
                R.id.action_square -> toSelectShape(R.string.action_square, squareShape)
                R.id.action_ellipse -> toSelectShape(R.string.action_ellipse, ellipseShape)
                R.id.action_cube -> toSelectShape(R.string.action_cube, cubeShape)
                R.id.action_lineOO -> toSelectShape(R.string.action_lineOO, lineOOShape)

                R.id.btnLine -> toSelectShape(R.string.action_line, lineShape)
                R.id.btnPoint -> toSelectShape(R.string.action_point, pointShape)
                R.id.btnRect -> toSelectShape(R.string.action_rectangle, rectangleShape)
                R.id.btnSquare -> toSelectShape(R.string.action_square, squareShape)
                R.id.btnEllipse -> toSelectShape(R.string.action_ellipse, ellipseShape)
                R.id.btnCube -> toSelectShape(R.string.action_cube, cubeShape)
                R.id.btnLineOO -> toSelectShape(R.string.action_lineOO, lineOOShape)
            }
            return super.onOptionsItemSelected(item)
        }
    }
}
