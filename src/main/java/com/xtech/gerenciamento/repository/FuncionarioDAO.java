/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtech.gerenciamento.repository;

import com.xtech.gerenciamento.model.FuncionarioBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class FuncionarioDAO {
    
    public List<FuncionarioBEAN> lerTodos(){
        List <FuncionarioBEAN> dados = new ArrayList<>();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            while(rs.next()){
                FuncionarioBEAN funcionario = new FuncionarioBEAN();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                
                dados.add(funcionario);
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return dados;
    }
    
    public FuncionarioBEAN lerID(int id){
        FuncionarioBEAN Funcionario = new FuncionarioBEAN();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                
                
                Funcionario.setId(rs.getInt("id"));
                Funcionario.setNome(rs.getString("nome"));
                Funcionario.setCargo(rs.getString("cargo"));
                Funcionario.setDepartamento(rs.getString("departamento"));
                Funcionario.setEmail(rs.getString("email"));
                Funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                               
            }
    }catch (SQLException e){
           e.printStackTrace();
        }
    return Funcionario;
}
    public void Salvar(FuncionarioBEAN update){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("UPDATE funcionario SET nome = ?, cargo = ?, departamento = ?, email = ?, data_contratacao = ? WHERE id = ? ");
            
  
                stmt.setString(1, update.getNome());
                stmt.setString(2, update.getCargo());
                stmt.setString(3, update.getDepartamento());
                stmt.setString(4, update.getEmail());
                stmt.setDate(5, update.getDataContratacao());
                stmt.setInt(6, update.getId());
                
                 stmt.executeUpdate();
            
    }catch (SQLException e){
           e.printStackTrace();
        }
    
}
  public void Inserir(FuncionarioBEAN inserir){
      try{
          Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
          
          stmt = conn.prepareStatement("INSERT INTO funcionario ( nome, cargo, departamento, email, data_contratacao) VALUES (?,?,?,?,?)");
          
          stmt.setString(1, inserir.getNome());
          stmt.setString(2, inserir.getCargo());
          stmt.setString(3, inserir.getDepartamento());
          stmt.setString(4, inserir.getEmail());
          stmt.setDate(5, inserir.getDataContratacao());
          stmt.executeUpdate();
      }catch(SQLException e){
          e.printStackTrace();
      }
      
  }

public void Deletar(int id){
    try{
         Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
          
          stmt = conn.prepareStatement("DELETE FROM funcionario WHERE id = ?");       
          stmt.setInt(1, id);
          stmt.executeUpdate();
    }catch(SQLException e){
          e.printStackTrace();
      }
}
    
}
