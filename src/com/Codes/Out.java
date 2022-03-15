package com.Codes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Out {

    public static List<Object> log = new ArrayList<>();

    public static void println(Object s) {
        log.add(s);
        update();
    }

    public static void println(String s) {
        log.add(s);
        update();
    }

    public static void println(double s) {
        log.add(s);
        update();
    }

    public static void println(int s) {
        log.add(s);
        update();
    }
    public static JFrame f = new JFrame(AppConfig.APPNAME + " Logger");
    public static JTextArea a = new JTextArea("");
    public static JScrollPane p = new JScrollPane();
    public static boolean b = false;

    public static void update() {
        String text = "";
        for (Object object : log) {
            text = text.concat(object + "\n");
        }
        a.setText(text);
    }

    public static void show() {
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                b = false;
            }

        });
        f.setSize(400, 400);
        String text = "";
        for (Object object : log) {
            text = text.concat(object + "\n");
        }
        a = new JTextArea(text);
        p = new JScrollPane();
        p.setViewportView(a);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.LINE_AXIS));
        f.getContentPane().add(p);
        f.setVisible(true);
        b = true;
    }
}
