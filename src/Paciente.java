public class Paciente {
    String nome;
    int idade;
    String historicoMedico;
    String ultimaConsulta;

    Paciente proximo;

    Paciente(String nome, int idade, String historicoMedico, String ultimaConsulta) {
        this.nome = nome;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
        this.ultimaConsulta = ultimaConsulta;
        this.proximo = null;
    }
}
