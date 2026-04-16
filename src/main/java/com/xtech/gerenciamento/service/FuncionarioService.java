/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtech.gerenciamento.service;

import com.xtech.gerenciamento.model.FuncionarioBEAN;
import com.xtech.gerenciamento.repository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioDAO repository;
    
    public List<FuncionarioBEAN> lerTodos() {
       return repository.lerTodos();
    }
    
    public FuncionarioBEAN lerID(int id){
        
        return repository.lerID(id);
    }
    
    public void Editar(FuncionarioBEAN funcionario){       
        repository.Salvar(funcionario);
    }
    
    public void Inserir(FuncionarioBEAN inserir){
        repository.Inserir(inserir);
    }
    
    public void Deletar(int id){
        repository.Deletar(id);
    }
}
