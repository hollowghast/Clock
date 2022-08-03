package ui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ClockDialog extends JDialog
{

    private boolean wasOk;
    
    public ClockDialog(JFrame owner, boolean modal)
    {
        super(owner, modal);
        init();
    }
    
    private void init(){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Clock");
        this.setLayout(new GridLayout(4, 2));
        
        wasOk = false;
        
        /* Labels start */
        lbTitle = new JLabel("Title");
        lbOffset = new JLabel("Offset");
        /* Labels stop */
        
        
        /* textfields start */
        tfTitle = new JTextField("eg Paris");
        tfOffset = new JTextField("0");
        /* textfields stop */
        
        
        /* buttons start */
        onOK = new JButton("OK");
        onOK.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(!tfTitle.getText().equals("")){
                    try{
                        Integer.parseInt(tfOffset.getText());
                        wasOk = true;
                        ClockDialog.this.dispose();
                    } catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(ClockDialog.this,
                                "Offset can't be used", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        wasOk = false;
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(ClockDialog.this,
                                "Empty title can't be used", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    wasOk = false;
                }
            }
        });
        onCancel = new JButton("Cancel");
        onCancel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
            }
        });
        onReset = new JButton("Empty fields");
        onReset.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                tfTitle.setText("");
                tfOffset.setText("");
            }
        });
        /* buttons stop */
        
        
        /* radiobuttons start */
        rbAnalog = new JRadioButton("Analog");
        rbDigital = new JRadioButton("Digital");
        clockTypes = new ButtonGroup();
        clockTypes.add(rbAnalog);
        clockTypes.add(rbDigital);
        
        plRadios = new JPanel();
        plRadios.add(rbAnalog);
        plRadios.add(rbDigital);
        
        rbDigital.setSelected(true);
        /* radiobuttons stop */
        
        
        this.add(lbTitle);
        this.add(tfTitle);
        this.add(lbOffset);
        this.add(tfOffset);
        this.add(plRadios);
        this.add(onOK);
        this.add(onCancel);
        this.add(onReset);
    }
    

    private JLabel lbTitle, lbOffset;
    private JTextField tfTitle, tfOffset;
    private JButton onOK, onCancel, onReset;
    private JRadioButton rbAnalog, rbDigital;
    private ButtonGroup clockTypes;
    private JPanel plRadios;
    
    public String getClockTitle(){
        return tfTitle.getText();
    }
    public int getClockOffset(){
        return Integer.parseInt(tfTitle.getText());
    }
    
    public boolean wasOk(){
        return wasOk;
    }
}
