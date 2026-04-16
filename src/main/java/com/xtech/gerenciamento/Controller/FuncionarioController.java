/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtech.gerenciamento.Controller;

import com.xtech.gerenciamento.model.FuncionarioBEAN;
import com.xtech.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aluno
 */
@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService servico;
    
    
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model){
        List<FuncionarioBEAN> lista = servico.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }
    
    @GetMapping("/perfil")
    public String getFuncionarioID(@RequestParam int id, Model model){
        FuncionarioBEAN funcionario = servico.lerID(id);      
        model.addAttribute("funcionario", funcionario);
        return "perfil";
    }
    @PostMapping("/salvar")
    public String salvarDados(@ModelAttribute FuncionarioBEAN funcionario){
        servico.Editar(funcionario);
        return "redirect:/funcionarios";
    }
    @PostMapping("/inserir")
    public String inserirDados(@ModelAttribute FuncionarioBEAN funcionario ){
        servico.Inserir(funcionario);
        return "redirect:/funcionarios";
    }
    @PostMapping("/deletar")
    public String deletarDados(@ModelAttribute int id ){
        servico.Deletar(id);
        return "redirect:/deletar";
    }
}
