package usuario;

import mecanismosDoJogo.Jogo;
import mecanismosDoJogo.AtributoInvalidoException;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Serializacao {

	public static void salvaJogo(Jogo jogo) throws AtributoInvalidoException {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jogo.ser"))) {

			oos.writeObject(jogo);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static Jogo carregaJogo() throws AtributoInvalidoException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jogo.ser"))) {

			Jogo jogoCarregado = (Jogo) ois.readObject();
			return jogoCarregado;

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		Jogo jogoCarregado = new Jogo(true);
		return jogoCarregado;

	}

	public static void salvaRanking(Ranking ranking) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ranking.ser"))) {

			oos.writeObject(ranking);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static Ranking carregaRanking() {

		Ranking rankingCarregado = new Ranking();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.ser"))) {

			rankingCarregado = (Ranking) ois.readObject();
			return rankingCarregado;

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		return rankingCarregado;

	}

}
