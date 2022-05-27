import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{
    Contatore c;
    int nCifre = 3; //numero di cifre di questo contatore
    
    public static void main(String[] args) {
        (new Main()).setVisible(true);
    }

    Main(){
        super();
        creaFrame();
    }

    private void creaFrame(){
        Container integrato= this.getContentPane();
        integrato.setLayout(new GridLayout(3,1));
        JButton btn = new JButton("+");
        btn.addActionListener(this);
        integrato.add(btn);
        c = new Contatore(nCifre);
        integrato.add(c);
        btn = new JButton("R");
        btn.addActionListener(this);
        integrato.add(btn);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){
            JButton btn = (JButton) e.getSource();
            switch (btn.getText()) {
                case "+"    :   //c.plus(nCifre-1)
                                if (c.plusR(nCifre-1)) c.reset();
                                break;
                case "R"    :   c.reset();
                                break;
            }
        }
    }
}
