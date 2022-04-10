package ru.geekbrains.java_two.lesson_a;

import java.awt.*;

public class Background extends Ball {

    private float time;
    private static final float AMPLITUDE = 250f / 2f;
    private Color color;

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int color1 = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.cos(time));
        int color2 = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.cos(time));
        int color3 = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        int color4 = Math.round(75);
        color = new Color(color1,color2,color3,color4);
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }

}
