package com.galaxy.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;

    String imagePath = "images/boy/boy1/";

    int[][] startArr = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    int step = 0;

    JMenuItem boyItem = new JMenuItem("帅哥");
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("联系开发者");

    public GameJFrame() {
        initJFrame();
        initJMenuBar();
        initData();
        initImage();
        this.setVisible(true);
    }

    private void initData() {
        int rows = startArr.length;
        int cols = startArr[0].length;
        int[] tempArr = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempArr[i * rows + j] = startArr[i][j];
            }
        }
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel jLabel = new JLabel(new ImageIcon("images/win.png"));
            jLabel.setBounds(180,264,197,73);
            this.getContentPane().add(jLabel);
        }
        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(10,10,100,20);
        this.getContentPane().add(stepCount);

        JLabel moveTip = new JLabel("按上下左右移动");
        moveTip.setBounds(400,0,200,40);
        this.getContentPane().add(moveTip);

        JLabel gameTip = new JLabel("按住a查看原始图片");
        gameTip.setBounds(220,520,200,40);
        this.getContentPane().add(gameTip);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(imagePath + data[i][j] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 60, 105 * i + 100, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }
        JLabel bgJLabel = new JLabel(new ImageIcon("images/background.png"));
        bgJLabel.setBounds(16,6,508,560);
        this.getContentPane().add(bgJLabel);
        this.getContentPane().repaint();
    }

    private void initJFrame() {
        this.setSize(540, 640);
        this.setTitle("拼图单机版 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeJMenu = new JMenu("更换图片");

        changeJMenu.add(boyItem);
        changeJMenu.add(girlItem);
        changeJMenu.add(animalItem);
        changeJMenu.add(sportItem);

        functionJMenu.add(changeJMenu);
        functionJMenu.add(replayItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        boyItem.addActionListener(this);
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        replayItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        this.setJMenuBar(jMenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(imagePath + "all.jpg"));
            jLabel.setBounds(60,100,420,420);
            this.getContentPane().add(jLabel);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
        }else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
        } else if (code == 87) {
            data = startArr;
        }
        initImage();
    }

    private boolean victory() {
        for (int i = 0; i < startArr.length; i++) {
            for (int j = 0; j < startArr[0].length; j++) {
                if (startArr[i][j] != data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (object == replayItem) {
            step = 0;
            initData();
            initImage();
        } else if (object == closeItem) {
            System.exit(0);
        } else if (object == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("images/myWechat.jpg"));
            jLabel.setBounds(0,0,300,300);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(400,420);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (object == boyItem) {
            Random r = new Random();
            int index = r.nextInt(3) + 1;
            imagePath = "images/boy/" + "boy" + index +"/";
            step  = 0;
            initData();
            initImage();
        } else if (object == girlItem) {
            Random r = new Random();
            int index = r.nextInt(13) + 1;
            imagePath = "images/girl/" + "girl" + index +"/";
            step  = 0;
            initData();
            initImage();
        } else if (object == animalItem) {
            Random r = new Random();
            int index = r.nextInt(8) + 1;
            imagePath = "images/animal/" + "animal" + index +"/";
            step  = 0;
            initData();
            initImage();
        } else if (object == sportItem) {
            Random r = new Random();
            int index = r.nextInt(10) + 1;
            imagePath = "images/sport/" + "sport" + index +"/";
            step  = 0;
            initData();
            initImage();
        }
    }


}
