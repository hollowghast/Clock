package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUI extends JFrame
{

    public GUI()
    {
        init();
    }

    private void init()
    {
        //initial config
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Uhrenanzeige");
        this.setLayout(new GridLayout(1, 3));

        /* Labels start */
        lbMainClock = new JLabel("Main Clock");
        lbSecClock = new JLabel();
        lbThirdClock = new JLabel();
        /* Labels stop */

        /* Radios start */
        rbMainClock = new JRadioButton();
        rbMainClock.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //Dialog aufrufend
                dlg = new ClockDialog(GUI.this, true);
                dlg.setVisible(true);
                if (dlg.wasOk()) {
                    //add new clock

                }
            }

        });
        rbSecClock = new JRadioButton();
        rbThirdClock = new JRadioButton();
        /* Radios stop */

        /* Panels start */
        panelTitles = new JPanel(new GridLayout(3, 2));
        panelTitles.add(lbMainClock);
        panelTitles.add(rbMainClock);
        panelTitles.add(lbSecClock);
        panelTitles.add(rbSecClock);
        panelTitles.add(lbThirdClock);
        panelTitles.add(rbThirdClock);

        panelClocksDigital = new JPanel(new GridLayout(3, 1));

        panelClockAnalog = new JPanel(new BorderLayout());
        /* Panels stop */

        //finals
        this.add(panelTitles);
        this.add(panelClocksDigital);
        this.add(panelClockAnalog);
    }

    private JPanel panelTitles, panelClocksDigital, panelClockAnalog;
    private JLabel lbMainClock, lbSecClock, lbThirdClock;
    private JRadioButton rbMainClock, rbSecClock, rbThirdClock;

    private ClockDialog dlg;

    private MouseAdapter mouseAdapter;
}
