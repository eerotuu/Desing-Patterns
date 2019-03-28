/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Implemented graphics by modifying code found in:
 * https://www.c-sharpcorner.com/UploadFile/433c33/creating-analog-clock-in-java/
 *
 * @author Eero
 */
public class AnalogClock extends JPanel implements Observer {

    private ClockTimer timer;
    private int xcenter = 195, ycenter = 185, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;

    public AnalogClock(ClockTimer c) {
        timer = c;
        timer.attach(this);
    }

    public void start() {
        init();
        new Thread(timer).start();
    }

    private void init() {
        JFrame window = new JFrame("AnalogClock");
        Color c = new Color(206, 187, 158);
        window.setBackground(c);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 400, 400);
        window.getContentPane().add(this);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void update(Subject s) {
        if (s == timer) {
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        int xhour, yhour, xminute, yminute, xsecond, ysecond, second, minute, hour;
        Graphics2D g2 = (Graphics2D) g;
        drawStructure(g2);

        second = timer.getSeconds();
        minute = timer.getMinutes();
        hour = timer.getHours();

        xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
        ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
        xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
        yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
        xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + xcenter);
        yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + ycenter);

        g2.setColor(Color.black);

        if (xminute != lastxm || yminute != lastym) {
            g2.drawLine(xcenter, ycenter - 1, lastxm, lastym);
            g2.drawLine(xcenter - 1, ycenter, lastxm, lastym);
        }
        if (xhour != lastxh || yhour != lastyh) {
            g2.drawLine(xcenter, ycenter - 1, lastxh, lastyh);
            g2.drawLine(xcenter - 1, ycenter, lastxh, lastyh);
        }

        g2.setStroke(new BasicStroke(3));
        g2.drawLine(xcenter, ycenter, xsecond, ysecond);

        g2.setStroke(new BasicStroke(5));
        g2.drawLine(xcenter, ycenter - 1, xminute, yminute);
        g2.drawLine(xcenter - 1, ycenter, xminute, yminute);

        g2.setStroke(new BasicStroke(7));
        g2.drawLine(xcenter, ycenter - 1, xhour, yhour);
        g2.drawLine(xcenter - 1, ycenter, xhour, yhour);

        lastxm = xminute;
        lastym = yminute;
        lastxh = xhour;
        lastyh = yhour;
    }

    private void drawStructure(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g2.setColor(new Color(234, 234, 234));
        g2.fillOval(xcenter - 150, ycenter - 150, 300, 300);

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval(xcenter - 150, ycenter - 150, 300, 300);
        g2.fillOval(xcenter - 10, ycenter - 10, 20, 20);

        g2.drawString("9", xcenter - 140, ycenter + 7);
        g2.drawString("3", xcenter + 130, ycenter + 7);
        g2.drawString("12", xcenter - 10, ycenter - 125);
        g2.drawString("6", xcenter - 5, ycenter + 140);
    }
}
