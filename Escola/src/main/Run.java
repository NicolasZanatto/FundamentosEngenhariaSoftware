package main;

import java.util.ArrayList;

import dao.AlunoDAO;
import dao.AvisoDAO;
import dao.DisciplinaDAO;
import dao.NotaDAO;
import model.Aluno;
import model.Aviso;
import model.Disciplina;
import model.Nota;
import view.AvisoView;

public class Run {

	public static void main(String[] args) {
		new AvisoView().setVisible(true);
				
		/*Nota nota = new Nota();
		
		nota.setIdnota(1);
		nota.setIdaluno(2);
		nota.setIddisciplina(2);
		nota.setNota(9);
		notaDAO.atualizar(nota);
		
		NotaDAO notaDAO = new NotaDAO();
		ArrayList<Nota> notas = notaDAO.listarTodos();
		for(Nota nota : notas)
			System.out.println(nota.getNota());*/
	}

}
