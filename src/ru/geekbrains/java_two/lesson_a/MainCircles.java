package ru.geekbrains.java_two.lesson_a;

/**
 * написать КЛАСС Background, изменяющий цвет канвы в зависимости от времени в приложении
 * реализовать добавление новых кружков по клику, используя ТОЛЬКО массивы
 * реализовать по клику другой кнопки удаление кружков
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Ball[] sprites = new Ball[10];
    private int spritesCount;

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(canvas, g);
        }
    }
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }

    private void initApplication() {
        addSprite(new Background());
    }

    private void addSprite(Ball s) {
        if (spritesCount == sprites.length) {
            Ball[] temp = new Ball[sprites.length * 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length);
            sprites = temp;
        }
        sprites[spritesCount++] = s;
    }

    private void removeSprite() {
        if (spritesCount > 1) spritesCount--;
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addSprite(new Ball());
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite();
            }
        });
        initApplication();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainCircles();
    }

}