package interfaceGrafica;

import mecanismosDoJogo.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.Serializable;

public class TelaTabuleiro extends JFrame implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	JPanel tela;
	ButtonCelula[][] botoes;
	Tabuleiro tabuleiro;
	JButton botaoReset;

	public TelaTabuleiro(Tabuleiro tabuleiro) {

		this.tabuleiro = tabuleiro;
		this.tela = new JPanel();
		this.tela.setLayout(null);
		this.add(tela);
		this.botoes = new ButtonCelula[Constante.larguraDasCasas][Constante.alturaDasCasas];

		for (int i = 0; i < Constante.larguraDasCasas; i++) {

			for (int j = 0; j < Constante.alturaDasCasas; j++) {

				this.botoes[i][j] = new ButtonCelula(this.tabuleiro, this);
				tabuleiro.getCelula(i, j).setButton(botoes[i][j]);
				this.botoes[i][j].setPos(i, j);
				this.botoes[i][j].setSize(Constante.tamCelula, Constante.tamCelula);
				this.botoes[i][j].setLocation(Constante.tamCelula * i, Constante.tamCelula * j);
				this.tela.add(botoes[i][j]);

			}

		}

		ajustes();

	}

	public void ajustes() {

		this.setSize((Constante.larguraDasCasas * Constante.tamCelula) + 18,
				Constante.alturaDasCasas * Constante.tamCelula + 100);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.botaoReset = new JButton();
		this.tela.add(this.botaoReset);
		this.botaoReset.addActionListener((java.awt.event.ActionEvent evt) -> {

			this.resetar();

		});

		this.botaoReset.setSize(Constante.tamCelula, Constante.tamCelula);
		this.botaoReset.setLocation((Constante.larguraDasCasas * Constante.tamCelula) / 3 + 18,
				Constante.alturaDasCasas * Constante.tamCelula + 10);
		this.botaoResetar();

	}

	public void mostraTodasMinas() {

		for (int i = 0; i < Constante.larguraDasCasas; i++) {

			for (int j = 0; j < Constante.alturaDasCasas; j++) {

				if (this.botoes[i][j].c.getTemMina()) {

					this.botoes[i][j].ehMina("-1");

				}

			}

		}

		this.inativaBotoes();

	}

	public void statusfinal() {

		if (this.tabuleiro.venceu()) {

			System.out.println("Você Ganhou");
			this.inativaBotoes();

		}

		if (this.tabuleiro.perdeu()) {

			System.out.println("Você Perdeu");
			this.inativaBotoes();

		}

	}

	public void inativaBotoes() {

		for (int i = 0; i < Constante.larguraDasCasas; i++) {

			for (int j = 0; j < Constante.alturaDasCasas; j++) {

				this.botoes[i][j].setEnabled(false);

			}

		}

	}

	public void resetar() {

		for (int i = 0; i < Constante.larguraDasCasas; i++) {

			for (int j = 0; j < Constante.alturaDasCasas; j++) {

				this.botoes[i][j].resetar();

			}

		}

		this.tabuleiro.adicionarMinas();

	}

	public void botaoResetar() {

		try {

			Image resetar = ImageIO.read(getClass().getResource("resetar.jpg"));
			resetar = resetar.getScaledInstance(Constante.tamCelula, Constante.tamCelula, java.awt.Image.SCALE_SMOOTH);
			this.botaoReset.setIcon(new ImageIcon(resetar));

		} catch (Exception exception) {

			System.out.println("Erro");

		}

	}

	public void retirarAviso() {

		// Método apenas para retirar o aviso do eclipse de que o objeto não estava
		// sendo utilizado na classe jogo

	}

}