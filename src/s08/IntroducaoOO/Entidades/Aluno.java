package s08.IntroducaoOO.Entidades;

public class Aluno {

	private String nomeAluno;
	private double notaTrimestre1;
	private double notaTrimestre2;
	private double notaTrimestre3;

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public void setNotaTrimestre1(double notaTrimestre1) {
		this.notaTrimestre1 = notaTrimestre1;
	}

	public void setNotaTrimestre2(double notaTrimestre2) {
		this.notaTrimestre2 = notaTrimestre2;
	}

	public void setNotaTrimestre3(double notaTrimestre3) {
		this.notaTrimestre3 = notaTrimestre3;
	}

	public String toString() {
		String avaliacaoFinal;
		double notaFinal = notaTrimestre1 + notaTrimestre2 + notaTrimestre3;
		avaliacaoFinal = "ALUNO: " + nomeAluno + "\nNOTA FINAL = " + notaFinal;
		if (notaFinal >= 60) {
			avaliacaoFinal += "\nAPROVADO!\n";
		} else {
			avaliacaoFinal += "\nREPROVADO!\nFALTOU " + String.format("%.2f", (60 - notaFinal))
					+ " PONTOS PARA ATINGIR A MÉDIA!";
		}

		return avaliacaoFinal;
	}

}
