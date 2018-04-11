package com.jlhuang9.bam;

import com.jlhuang9.bam.biz.Bank;
import com.jlhuang9.bam.biz.TextView;
import com.jlhuang9.bam.entry.Account;
import com.jlhuang9.bam.exception.RegisterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 {
    private static final TextView textView = Bank.getInstance();

    public static void main(String[] args) {

        Window w = new Window();
    }

    static class Window extends Frame implements ActionListener {
        JFrame frame;
        JButton registered_btn;
        JButton reset;

        public Window() {
            frame = new JFrame("测试");
            frame.setBounds(300, 200, 500, 500);
            frame.getContentPane().setLayout(null);
            frame.setBackground(Color.blue);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registered_btn = new JButton("注册");
            registered_btn.setBounds(38, 197, 93, 60);
            registered_btn.addActionListener(this);
            frame.getContentPane().add(registered_btn);

            reset = new JButton("重置");
            reset.setBounds(200, 197, 93, 60);
            reset.addActionListener(this);
            frame.getContentPane().add(reset);
        }

        private Registered registered = new Registered();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registered_btn) {
                System.out.println("注册");
                registered.show();
            } else if (e.getSource() == reset) {
                registered.toBack();
            }
        }
    }

    static class Registered extends JFrame implements ActionListener {
        String[] ipts = { "密码", "确认密码", "真实姓名", "身份证号"};
        int height = 20;
        int width = 70;
        int X = 50;
        int Y = 30;
        int add = 30;
        JTextField[] textFields = new JTextField[ipts.length];
        String[] values = new String[ipts.length];
        JButton registered_btn;

        String[] checkValues = {"储蓄账户", "信用账户"};
        JRadioButton checkbox[] = new JRadioButton[checkValues.length];
        ButtonGroup sele = new ButtonGroup();


        public Registered() {
            super("注册页！");
            Container contentPane = this.getContentPane();
            this.setBounds(300, 400, 300, 300);
            contentPane.setLayout(null);
            this.setBackground(Color.blue);

            for (int i = 0; i < ipts.length; i++) {
                String ipt = ipts[i];
                JLabel label = new JLabel(ipt + ":");
                label.setBounds(X, Y, width, height);
                JTextField text = new JTextField();
                text.setBounds(X + 100, Y, width, height);
                textFields[i] = text;
                contentPane.add(label);
                contentPane.add(text);
                Y += add;
            }

            for (int i = 0; i < checkValues.length; i++) {
                checkbox[i] = new JRadioButton(checkValues[i], i == 0);
                checkbox[i].setBounds(X, Y, width+30, height);
                X += 100;
                sele.add(checkbox[i]);
                contentPane.add(checkbox[i]);
            }

            registered_btn = new JButton("注册");
            registered_btn.setBounds(30, 200, 60, 30);
            registered_btn.addActionListener(this);
            contentPane.add(registered_btn);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registered_btn) {
                for (int i = 0; i < textFields.length; i++) {
                    values[i] = textFields[i].getText();
                }
                try {
                    int type = 0;
                    for (int i = 1; i < checkbox.length; i++) {
                        if (checkbox[i].isSelected()) {
                            type = i;
                            break;
                        }
                    }
                    Account register = textView.register(values, type);
                    JOptionPane.showConfirmDialog(null, "注册成功！您的账号是： " + register.getId(),"成功",JOptionPane.OK_CANCEL_OPTION);
                } catch (RegisterException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "注册验证异常！", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}


