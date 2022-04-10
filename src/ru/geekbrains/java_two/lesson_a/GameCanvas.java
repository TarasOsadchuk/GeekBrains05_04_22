package ru.geekbrains.java_two.lesson_a;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private long lastFrameTime;
    private MainCircles controller;

    GameCanvas(MainCircles controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) { // do
        super.paintComponent(g);
        // no payload = 250fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        controller.onDrawCanvas(this, g, deltaTime);
        try {
            Thread.sleep(16); // 1 / 60 frames = 16.(6) fps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint(); // } while (true);
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

}