package edu.Escola.infrastructure.repository.jdbc;

import edu.Escola.core.application.interfaces.AlunoRepository;
import edu.Escola.core.domain.entities.Aluno;
import edu.Escola.core.domain.valueObject.Cpf;
import edu.Escola.core.domain.valueObject.Email;
import edu.Escola.core.domain.valueObject.Telefone;
import edu.Escola.infrastructure.exceptions.AlunoNaoEncontrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAlunoRepository implements AlunoRepository {

    private final Connection connection;

    public JdbcAlunoRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES(? ,? ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO ALUNO VALUES(? ,?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()){
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(Cpf cpf) {
        String sqlAluno = "SELECT NOME, EMAIL FROM ALUNO WHERE CPF = ?";
        String sqlTelefones = "SELECT DDD, NUMERO FROM TELEFONE WHERE CPF_ALUNO = ?";
        Aluno aluno = null;

        try {
            PreparedStatement psAluno = connection.prepareStatement(sqlAluno);
            psAluno.setString(1, cpf.getNumero());
            ResultSet rsAluno = psAluno.executeQuery();

            if (rsAluno.next()) {
                String nome = rsAluno.getString("NOME");
                String email = rsAluno.getString("EMAIL");
                aluno = new Aluno(new Cpf(cpf.getNumero()), nome, new Email(email));

                PreparedStatement psTelefones = connection.prepareStatement(sqlTelefones);
                psTelefones.setString(1, cpf.getNumero());
                ResultSet rsTelefones = psTelefones.executeQuery();
                while (rsTelefones.next()) {
                    String ddd = rsTelefones.getString("DDD");
                    String numero = rsTelefones.getString("NUMERO");
                    aluno.adicionarTelefone(ddd, numero);
                }
            }
        } catch (SQLException e) {
            throw new AlunoNaoEncontrado(cpf);
        }

        return aluno;
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sqlAlunos = "SELECT * FROM ALUNO";
        String sqlTelefones = "SELECT DDD, NUMERO FROM TELEFONE WHERE CPF_ALUNO = ?";

        try {
            PreparedStatement psAlunos = connection.prepareStatement(sqlAlunos);
            ResultSet rsAlunos = psAlunos.executeQuery();

            while (rsAlunos.next()) {
                String cpf = rsAlunos.getString("CPF");
                String nome = rsAlunos.getString("NOME");
                String email = rsAlunos.getString("EMAIL");
                Aluno aluno = new Aluno(new Cpf(cpf), nome, new Email(email));

                PreparedStatement psTelefones = connection.prepareStatement(sqlTelefones);
                psTelefones.setString(1, cpf);
                ResultSet rsTelefones = psTelefones.executeQuery();

                while (rsTelefones.next()) {
                    String ddd = rsTelefones.getString("DDD");
                    String numero = rsTelefones.getString("NUMERO");
                    aluno.adicionarTelefone(ddd, numero);
                }

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os alunos: " + e.getMessage(), e);
        }

        return alunos;
    }
}
