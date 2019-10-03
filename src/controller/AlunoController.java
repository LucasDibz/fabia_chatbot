package controller;

import javax.swing.JOptionPane;

import beans.Aluno;
import bo.AlunoBO;
import dao.AlunoDAO;

public class AlunoController {
	public static void main(String[] args) {
		try {
			int menu = 0;

			// Deve vir do Front-End
			do {
				int rm;
				AlunoBO alunoBO = new AlunoBO();
				Aluno aluno = new Aluno();
				AlunoDAO alunoDAO = new AlunoDAO();
				try {
					menu = Integer.parseInt(JOptionPane.showInputDialog(
							"MENU\n1 - Cadastrar Aluno\n2 - Consultar Aluno\n3 - Atualizar Senha\n4 - Deletar Aluno\n5 - Testar Login\n6 - Sair"));
				} catch (Exception x) {
					menu = 0;
				}

				switch (menu) {
				case 1:
					// Teste Cadastrar Aluno
					aluno.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("RM:")));
					aluno.setNome(JOptionPane.showInputDialog("Nome:"));
					aluno.setSenha(JOptionPane.showInputDialog("Senha:"));
					System.out.println(alunoBO.novoAluno(aluno));
					break;

				case 2:
					rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
					aluno = alunoDAO.getAluno(rm);
					System.out.println("Nome...: " + aluno.getNome());
					System.out.println("Senha..: " + aluno.getSenha());
					System.err.println("Código.: " + aluno.getCodigo());
					break;

				case 3:
					rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
					String newPass = JOptionPane.showInputDialog("Digite a nova Senha");
					alunoDAO.updatePasswordAluno(rm, newPass);
					break;

				case 4:
					rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
					int x = alunoDAO.deleteAluno(rm);
					if (x == 0)
						System.out.println("Aluno não encontrado");
					else
						System.out.println("Aluno deletado");
					break;

				case 5:
					rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM"));
					String senha = JOptionPane.showInputDialog("Digite a Senha");
					int y = alunoDAO.loginAluno(rm, senha);
					if (y == 0)
						System.out.println("Cadastro não encontrado");
					else
						System.out.println("Logado no Sistema!");
					break;
				}

			} while (menu != 6);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
