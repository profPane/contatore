import javax.swing.JPanel;
import java.awt.GridLayout;

public class Contatore extends JPanel{
    private int nCifre;
    Contatore(){
        this(4);
    }

    Contatore(int nCifre){
        super();
        this.nCifre=nCifre;
        creaContenuto();
    }

    private void creaContenuto(){
        this.setLayout(new GridLayout(1,nCifre));
        for (int i=0;i<nCifre;i++) this.add(new Cifra());
    }

    public void reset(){
        for (int i=0;i<nCifre;i++){
            Cifra attuale=(Cifra) this.getComponent(i);
            attuale.reset();
        }
    }

    //funzione ricorsiva per l'incremento del Contatore
    public boolean plusR(int posto){
        //-1 non è un componente Cifra valida su cui fare "riporto" quindi restutisco overflow
        if (posto<0) return true;
        if (((Cifra) this.getComponent(posto)).plus()){ //incremento fallito (overflow)
            ((Cifra) this.getComponent(posto)).reset(); //azzero la cifra attuale
            posto--; //mi sposto alla prossima cifra a SX
            return plusR(posto); //e "riporto 1" incrementandola
        } 
        return false; //incremento riuscito    
    }

    //incremento del Contatore "tradizionale"
    public void plus(int nCifre){
        boolean overflow=true;
        while ((overflow) && (nCifre>=0)){
            Cifra attuale=(Cifra) this.getComponent(nCifre);
            overflow=attuale.plus();
            //se c'è "riporto" imposto la cifra attuale a 0
            if (overflow) attuale.reset();
            //e passo alla prossia, cioè il prossimo componente Cifra a sinistra 
            nCifre--;
        }
    }
}