package interfaceGrafica;
import mecanismosDoJogo.*;

import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public final class ButtonCelula extends JButton {
 
   int linha;
   int coluna;
   Celula c;
   Tabuleiro tabuleiro;
   String s;
   TelaTabuleiro tabInterface;
   
   public ButtonCelula(Tabuleiro tabuleiro, TelaTabuleiro tabInterface) {
	   this.tabuleiro = tabuleiro;
	   this.tabInterface = tabInterface;
	   this.s = "";
	   this.setText(s);
	   
	   this.addActionListener((java.awt.event.ActionEvent evt) -> {
           buttonClicado(false);
         });
	   this.addMouseListener( new java.awt.event.MouseAdapter(){
		   public void mousePressed(MouseEvent c) {
			   if(SwingUtilities.isRightMouseButton(c)) {
				    buttonClicado(true);
			   }
		   }
		   
	   });
	   
	   
	   }
   
   
   public void buttonClicado(boolean rightClick) {
	   if (!rightClick) {
        if (!this.c.getMarcada()) this.clicar();
           
       } 
	   else {
           this.marcar();
       }
	   this.tabInterface.statusfinal();
   }
   
   public void clicar() {
	   
    int numVizinhasMinadas = c.clicar();
	   
	   if(c.getMinada()) {
		   this.tabInterface.mostraTodasMinas();
	   }
	   
	   
	   if(numVizinhasMinadas == 0) {
		   for(Celula vizinha: c.getVizinhas())
		   {
			   if(!vizinha.getClicada()) 
				   vizinha.getButton().clicar();				  
			  
		   }
	   } 
	   this.s = Integer. toString(numVizinhasMinadas);
	   this.ehMina(this.s);
	   
	   
   }
   public void marcar() {
       if (this.c.getClicada()) {
           return;
       }
       if (this.c.marcar()) {
           try {
               Image bandeira = ImageIO.read(getClass().getResource("bandeira.jpg"));
               bandeira = bandeira.getScaledInstance(Constante.tamCelula, Constante.tamCelula, java.awt.Image.SCALE_SMOOTH);
               this.setIcon(new ImageIcon(bandeira));
               } 
           catch (Exception exception) {
               this.setText("B");
           }
       } 
       else {
           this.setIcon(null);
           this.setText("");
       }
   }
   
   public void setPos(int linha,int coluna) {
	   this.linha = linha;
	   this.coluna = coluna;
	   this.c = tabuleiro.getCelula(linha, coluna);
   }
   public void ehMina(String revela){
	    if (revela.equals("-1")) {
           try {
               Image mina = ImageIO.read(getClass().getResource("mina.jpg"));
               mina = mina.getScaledInstance(Constante.tamCelula, Constante.tamCelula, java.awt.Image.SCALE_SMOOTH);
               this.setIcon(new ImageIcon(mina));
           } 
           catch (Exception exception) {
               this.setText("-1");
           }
       } else {
           this.setText(revela);
       }
	    this.setEnabled(false);
   }
   public void resetar() {
  	   this.c.reset();
  	   this.s = "";
	   this.setText(s);
	   this.setEnabled(true);
	   this.setIcon(null);
  	 
   }
   
    
}

