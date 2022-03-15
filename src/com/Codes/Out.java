package com.Codes;

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
    }

    public static void println(String s) {
        log.add(s);
    }

    public static void println(double s) {
        log.add(s);
    }

    public static void println(int s) {
        log.add(s);
    }

    public static void show() {
        JFrame f = new JFrame(AppConfig.APPNAME + " Logger");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(400, 400);
        String text = "";
        for (Object object : log) {
            text = text.concat(object + "\n");
        }
        JTextArea a = new JTextArea(text);
        JScrollPane p = new JScrollPane();
        p.setViewportView(a);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.LINE_AXIS));
        f.getContentPane().add(p);
        f.setVisible(true);
    }
}
