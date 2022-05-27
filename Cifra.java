import javax.swing.JLabel;

class Cifra extends JLabel{

    Cifra(){
        reset();
    }

    public void reset(){
        this.setText("0");
    }

    public boolean plus(){
        //leggo il valore attuale
        int attuale = Integer.parseInt(this.getText());
        if (attuale<9) { //se è minore di 9 lo incremento
            attuale++;
            this.setText(""+attuale);
            return false;
        }
        else return true; //altrimenti overflow
    }
}