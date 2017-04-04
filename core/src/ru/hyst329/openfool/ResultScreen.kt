package ru.hyst329.openfool

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.GlyphLayout

/**
 * Created by main on 18.03.2017.
 * Licensed under MIT License.
 */
internal class ResultScreen(private val game: OpenFoolGame, private val result: ResultScreen.Result) : Screen {

    internal enum class Result {
        WON,
        LOST,
        PARTNER_LOST,
        DRAW
    }

    override fun show() {

    }

    override fun render(delta: Float) {
        var color = Color.BLACK
        var header = ""
        var text = ""
        when (result) {
            ResultScreen.Result.WON -> {
                color = Color(0.2f, 0.6f, 0.125f, 1f)
                header = game.getLocaleBundle().get("VictoryHeader")
                text = game.getLocaleBundle().get("VictoryText")
            }
            ResultScreen.Result.LOST -> {
                color = Color(0.6f, 0.2f, 0.125f, 1f)
                header = game.getLocaleBundle().get("DefeatHeader")
                text = game.getLocaleBundle().get("DefeatText")
            }
            ResultScreen.Result.PARTNER_LOST -> {
                color = Color(0.6f, 0.4f, 0.125f, 1f)
                header = game.getLocaleBundle().get("PartnerDefeatHeader")
                text = game.getLocaleBundle().get("PartnerDefeatText")
            }
            ResultScreen.Result.DRAW -> {
                color = Color(0.6f, 0.6f, 0.125f, 1f)
                header = game.getLocaleBundle().get("DrawHeader")
                text = game.getLocaleBundle().get("DrawText")
            }
        }
        val headerLayout = GlyphLayout(game.getFont(), header)
        val textLayout = GlyphLayout(game.getFont(), text)
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        game.getBatch().begin()
        game.getFont().draw(game.getBatch(), headerLayout,
                400 - headerLayout.width / 2,
                400 - headerLayout.height / 2)
        game.getFont().draw(game.getBatch(), textLayout,
                400 - textLayout.width / 2,
                280 - textLayout.height / 2)
        game.getBatch().end()
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.screen = MainMenuScreen(game)
            dispose()
        }
    }

    override fun resize(width: Int, height: Int) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }

    override fun dispose() {

    }

}
