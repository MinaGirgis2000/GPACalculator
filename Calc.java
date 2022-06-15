import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class Calc extends JFrame implements ActionListener {

    JPanel panel1, classpanel, panel2;
    double c1, c2, c3, c4, c5, c6, c7, c8, g1, g2, g3, g4, g5, g6, g7, g8, gpa, pgpa, pcredits, totalcredits;
    double[] gr = new double[8];
    double[] cr = new double[8];
    double[] gpaC = new double[8];
    DefaultListModel<String> courses = new DefaultListModel<>();
    JList<String> l1 = new JList<>(courses);
    JList<String> l2 = new JList<>(courses);
    JList<String> l3 = new JList<>(courses);
    JList<String> l4 = new JList<>(courses);
    JList<String> l5 = new JList<>(courses);
    JList<String> l6 = new JList<>(courses);
    JList<String> l7 = new JList<>(courses);
    JList<String> l8 = new JList<>(courses);
    String[] list = new String[8];
    JLabel blank1, blank2, blank3, blank4, cred, grad, courseL, precred, pregpa;
    JTextField[] credits = new JTextField[9];
    JTextField[] grades = new JTextField[9];
    JLabel[] classNum = new JLabel[9];
    JButton[] levelB = new JButton[8];
    JButton calc, back;

    Calc() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(530, 565);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("GPA Calculator");
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            }

            public void mouseExited(MouseEvent evt) {
            }

            public void mousePressed(MouseEvent evt) {
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
            }
        });

        blank1 = new JLabel("");
        blank2 = new JLabel("");
        blank3 = new JLabel("");
        blank4 = new JLabel("");
        grad = new JLabel("       Grades");
        cred = new JLabel("       Credits");
        courseL = new JLabel("  Course Level");
        pregpa = new JLabel(" Pre-GPA");
        precred = new JLabel("Pre-Credits");

        l1.setBounds(376, 79, 128, 75);
        l1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l1.getSelectedValue();
                levelB[0].setText(t + " ▽");
                l1.setVisible(false);
            }
        });
        l2.setBounds(376, 119, 128, 75);
        l2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l2.getSelectedValue();
                levelB[1].setText(t + " ▽");
                l2.setVisible(false);
            }
        });
        l3.setBounds(376, 159, 128, 75);
        l3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l3.getSelectedValue();
                levelB[2].setText(t + " ▽");
                l3.setVisible(false);
            }
        });
        l4.setBounds(376, 199, 128, 75);
        l4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l4.getSelectedValue();
                levelB[3].setText(t + " ▽");
                l4.setVisible(false);
            }
        });
        l5.setBounds(376, 239, 128, 75);
        l5.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l5.getSelectedValue();
                levelB[4].setText(t + " ▽");
                l5.setVisible(false);
            }
        });
        l6.setBounds(376, 279, 128, 75);
        l6.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l6.getSelectedValue();
                levelB[5].setText(t + " ▽");
                l6.setVisible(false);
            }
        });
        l7.setBounds(376, 319, 128, 75);
        l7.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l7.getSelectedValue();
                levelB[6].setText(t + " ▽");
                l7.setVisible(false);
            }
        });
        l8.setBounds(376, 359, 128, 75);
        l8.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String t = l8.getSelectedValue();
                levelB[7].setText(t + " ▽");
                l8.setVisible(false);
            }
        });

        panel1 = new JPanel();
        panel1.setBounds(80, 5, 425, 440);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new GridLayout(11, 3, 20, 10));
        panel1.add(grad);
        panel1.add(cred);
        panel1.add(courseL);

        classpanel = new JPanel();
        classpanel.setBounds(10, 5, 50, 440);
        classpanel.setBackground(Color.WHITE);
        classpanel.setLayout(new GridLayout(11, 1, 20, 0));
        classpanel.add(blank1);

        panel2 = new JPanel();
        panel2.setBounds(15, 15, 320, 535);
        panel2.setLayout(new GridLayout(2, 2, 20, 10));

        courses.addElement("Course Level");
        courses.addElement("Academic");
        courses.addElement("Honors");
        courses.addElement("Advanced Placement");

        for (int i = 0; i < 9; i++) {
            if (i < 8) {
                levelB[i] = new JButton();
                levelB[i].setText("Course Level ▽");
                levelB[i].setFocusable(false);
                levelB[i].addActionListener(this);
            }
            credits[i] = new JTextField();
            credits[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD)) {
                        e.consume(); // if it's not a number, ignore the event
                    }
                }
            });
            grades[i] = new JTextField();
            grades[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD)) {
                        e.consume();
                    }
                }
            });
            classNum[i] = new JLabel("Class " + String.valueOf(++i));
            --i;
            if (i == 8) {
                classpanel.add(blank2);
                panel1.add(pregpa);
                panel1.add(precred);
                panel1.add(blank3);
            }
            classpanel.add(classNum[i]);
            panel1.add(grades[i]);
            panel1.add(credits[i]);
            if (i < 8) {
                panel1.add(levelB[i]);
            }
        }
        classNum[8].setText("Previous-GPA");

        calc = new JButton("Calculate");
        calc.setBounds(210, 470, 100, 25);
        calc.addActionListener(this);
        calc.setFocusable(false);

        back = new JButton("Back");
        back.setBounds(125, 470, 100, 25);
        back.addActionListener(this);
        back.setFocusable(false);

        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(calc);
        this.add(classpanel);
        this.add(panel1);
        this.add(panel2);
        this.add(back);
        this.setVisible(true);
        panel2.setVisible(false);
        back.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);
    }

    public static void main(String[] args) {
        new Calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calc) {
            for (int i = 0; i < 9; i++) {
                if (credits[i].getText() == "") {
                    credits[i].setText("0");
                }
                if (grades[i].getText() == "") {
                    grades[i].setText("0");
                }
            }

            cr[0] = c1 = Double.parseDouble(credits[0].getText());
            cr[1] = c2 = Double.parseDouble(credits[1].getText());
            cr[2] = c3 = Double.parseDouble(credits[2].getText());
            cr[3] = c4 = Double.parseDouble(credits[3].getText());
            cr[4] = c5 = Double.parseDouble(credits[4].getText());
            cr[5] = c6 = Double.parseDouble(credits[5].getText());
            cr[6] = c7 = Double.parseDouble(credits[6].getText());
            cr[7] = c8 = Double.parseDouble(credits[7].getText());

            gr[0] = g1 = Double.parseDouble(grades[0].getText());
            gr[1] = g2 = Double.parseDouble(grades[1].getText());
            gr[2] = g3 = Double.parseDouble(grades[2].getText());
            gr[3] = g4 = Double.parseDouble(grades[3].getText());
            gr[4] = g5 = Double.parseDouble(grades[4].getText());
            gr[5] = g6 = Double.parseDouble(grades[5].getText());
            gr[6] = g7 = Double.parseDouble(grades[6].getText());
            gr[7] = g8 = Double.parseDouble(grades[7].getText());

            pgpa = Double.parseDouble(grades[8].getText());
            pcredits = Double.parseDouble(credits[8].getText());

            totalcredits = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + pcredits;
            gpa = (c1 * g1) + (c2 * g2) + (c3 * g3) + (c4 * g4) + (c5 * g5) +
                    (c6 * g6) + (c7 * g7) + (c8 * g8) + (pcredits * pgpa);

            for (int i = 0; i < 8; i++) {
                list[i] = levelB[i].getText();
                if (list[i] == "Course Level ▽") {
                    list[i] = "Academic ▽";
                }
                switch (list[i]) {
                    case "Academic ▽":
                        if (gr[i] <= 59.49) {
                            gpaC[i] = 0.0;
                        } else if (gr[i] >= 59.5 && gr[i] <= 61.45) {
                            gpaC[i] = 0.7;
                        } else if (gr[i] >= 61.5 && gr[i] <= 65.49) {
                            gpaC[i] = 1.0;
                        } else if (gr[i] >= 65.5 && gr[i] <= 69.49) {
                            gpaC[i] = 1.3;
                        } else if (gr[i] >= 69.5 && gr[i] <= 71.49) {
                            gpaC[i] = 1.7;
                        } else if (gr[i] >= 71.5 && gr[i] <= 75.49) {
                            gpaC[i] = 2.0;
                        } else if (gr[i] >= 75.5 && gr[i] <= 79.49) {
                            gpaC[i] = 2.3;
                        } else if (gr[i] >= 79.5 && gr[i] <= 81.49) {
                            gpaC[i] = 2.7;
                        } else if (gr[i] >= 81.5 && gr[i] <= 85.49) {
                            gpaC[i] = 3.0;
                        } else if (gr[i] >= 85.5 && gr[i] <= 89.49) {
                            gpaC[i] = 3.3;
                        } else if (gr[i] >= 89.5 && gr[i] <= 91.49) {
                            gpaC[i] = 3.7;
                        } else if (gr[i] >= 91.5 && gr[i] <= 97.49) {
                            gpaC[i] = 4.0;
                        } else if (gr[i] >= 97.5) {
                            gpaC[i] = 4.3;
                        }
                        break;
                    case "Honors ▽":
                        if (gr[i] <= 59.49) {
                            gpaC[i] = 0.0;
                        } else if (gr[i] >= 59.5 && gr[i] <= 61.45) {
                            gpaC[i] = 0.805;
                        } else if (gr[i] >= 61.5 && gr[i] <= 65.49) {
                            gpaC[i] = 1.15;
                        } else if (gr[i] >= 65.5 && gr[i] <= 69.49) {
                            gpaC[i] = 1.338;
                        } else if (gr[i] >= 69.5 && gr[i] <= 71.49) {
                            gpaC[i] = 1.995;
                        } else if (gr[i] >= 71.5 && gr[i] <= 75.49) {
                            gpaC[i] = 2.3;
                        } else if (gr[i] >= 75.5 && gr[i] <= 79.49) {
                            gpaC[i] = 2.645;
                        } else if (gr[i] >= 79.5 && gr[i] <= 81.49) {
                            gpaC[i] = 3.105;
                        } else if (gr[i] >= 81.5 && gr[i] <= 85.49) {
                            gpaC[i] = 3.45;
                        } else if (gr[i] >= 85.5 && gr[i] <= 89.49) {
                            gpaC[i] = 3.795;
                        } else if (gr[i] >= 89.5 && gr[i] <= 91.49) {
                            gpaC[i] = 4.255;
                        } else if (gr[i] >= 91.5 && gr[i] <= 97.49) {
                            gpaC[i] = 4.6;
                        } else if (gr[i] >= 97.5) {
                            gpaC[i] = 4.945;
                        }
                        break;
                    case "Advanced Placement ▽":
                        if (gr[i] <= 59.49) {
                            gpaC[i] = 0.0;
                        } else if (gr[i] >= 59.5 && gr[i] <= 61.45) {
                            gpaC[i] = 0.875;
                        } else if (gr[i] >= 61.5 && gr[i] <= 65.49) {
                            gpaC[i] = 1.25;
                        } else if (gr[i] >= 65.5 && gr[i] <= 69.49) {
                            gpaC[i] = 1.625;
                        } else if (gr[i] >= 69.5 && gr[i] <= 71.49) {
                            gpaC[i] = 2.125;
                        } else if (gr[i] >= 71.5 && gr[i] <= 75.49) {
                            gpaC[i] = 2.5;
                        } else if (gr[i] >= 75.5 && gr[i] <= 79.49) {
                            gpaC[i] = 2.875;
                        } else if (gr[i] >= 79.5 && gr[i] <= 81.49) {
                            gpaC[i] = 3.375;
                        } else if (gr[i] >= 81.5 && gr[i] <= 85.49) {
                            gpaC[i] = 3.75;
                        } else if (gr[i] >= 85.5 && gr[i] <= 89.49) {
                            gpaC[i] = 4.125;
                        } else if (gr[i] >= 89.5 && gr[i] <= 91.49) {
                            gpaC[i] = 4.625;
                        } else if (gr[i] >= 91.5 && gr[i] <= 97.49) {
                            gpaC[i] = 5;
                        } else if (gr[i] >= 97.5) {
                            gpaC[i] = 5.375;
                        }
                        break;
                }
            }
            panel2.setVisible(true);
            back.setVisible(true);
        }
        for (int i = 0; i < 8; i++) {
            if (e.getSource() == levelB[i]) {
                levelB[i].setVisible(true);
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);

                switch (i) {
                    case 0:
                        l1.setVisible(true);
                        break;
                    case 1:
                        l2.setVisible(true);
                        break;
                    case 2:
                        l3.setVisible(true);
                        break;
                    case 3:
                        l4.setVisible(true);
                        break;
                    case 4:
                        l5.setVisible(true);
                        break;
                    case 5:
                        l6.setVisible(true);
                        break;
                    case 6:
                        l7.setVisible(true);
                        break;
                    case 7:
                        l8.setVisible(true);
                        break;
                }
            } else if (e.getSource() == back) {
                levelB[i].setVisible(true);
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                panel2.setVisible(false);
                back.setVisible(false);
            }
        }
    }
}
