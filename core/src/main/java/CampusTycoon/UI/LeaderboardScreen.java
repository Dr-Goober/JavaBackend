package CampusTycoon.UI;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.GameUtils;
import CampusTycoon.InputHandler;


public class LeaderboardScreen implements Screen{

    /** screen Displayed after the Leaderboard is selected. */
    public LeaderboardScreen() {
    }

    @Override
    public void show() {
        GameUtils.createLeaderboardUI();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);
        Drawer.drawAll();
    }

    @Override
    public void resize(int width, int height) {
        Window.updateResolution(width, height);
        Drawer.updateAll();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
        Drawer.clear();
        InputHandler.clear();
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
