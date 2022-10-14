package com.entra21.Transportadora.controller;

import com.entra21.Transportadora.model.dto.Funcionario.FuncionarioAddDTO;
import com.entra21.Transportadora.model.dto.Funcionario.FuncionarioDTO;
import com.entra21.Transportadora.model.dto.Funcionario.FuncionarioUpDTO;
import com.entra21.Transportadora.model.dto.Item.ItemUpDTO;
import com.entra21.Transportadora.model.entity.FuncionarioEntity;
import com.entra21.Transportadora.view.repository.FuncionarioRepository;
import com.entra21.Transportadora.view.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


        import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {

   @Autowired
   FuncionarioService funcionarioService;

   @Autowired
   FuncionarioRepository funcionarioRepository;


   @GetMapping
   public List<FuncionarioDTO> getAllFuncionario() {
      return funcionarioService.getAllFuncionario();
   }
   //todo
   //TIRAR O ENTITY
   @GetMapping("/{id}")
   public List<FuncionarioDTO> getAllByEmpresa(@PathVariable(name = "id")Long id){
      return funcionarioService.getAllFuncionarioById();
   }

   @PostMapping
   public void addFuncionario(
           @RequestBody FuncionarioAddDTO funcionarioPayLoadDTO
   ){
      funcionarioService.saveFuncionario(funcionarioPayLoadDTO);
   }

   @PutMapping("/{id}")
   public FuncionarioUpDTO updateFuncionario(@PathVariable(name = "id") Long id,
                                             @RequestBody FuncionarioUpDTO funcionarioUpDTO) {
      return funcionarioService.funcionarioUpDTO(id, funcionarioUpDTO);
   }
//
////    @Autowired
////    private FuncionarioRepository funcionarioRepository;
//
////    @GetMapping
////    public List<FuncionarioEntity> getAllFuncionarios(){
////        return funcionarioRepository.findAll();
////    }

}
