package com.entra21.Transportadora.controller;

import com.entra21.Transportadora.model.dto.FuncionarioDTO;
import com.entra21.Transportadora.model.dto.FuncionarioPayLoadDTO;
import com.entra21.Transportadora.model.dto.ItemDTO;
import com.entra21.Transportadora.model.entity.PessoaEntity;
import com.entra21.Transportadora.view.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {

   @Autowired
   FuncionarioService funcionarioService;


   @GetMapping
   public List<FuncionarioDTO> getAllFuncionario() {
       return funcionarioService.getAllFuncionario();
   }

   @PostMapping
   public void addFuncionario(
           @RequestBody FuncionarioPayLoadDTO funcionarioPayLoadDTO
   ){
      funcionarioService.saveFuncionario(funcionarioPayLoadDTO);
   }
   @PutMapping("/{id}")
   public FuncionarioPayLoadDTO updateAllFuncionario(@PathVariable(name = "id") Long id,
                             @RequestBody FuncionarioPayLoadDTO funcionarioPayLoadDTO) {
      return funcionarioService.updateAllFuncionario(id, funcionarioPayLoadDTO);
   }
}
