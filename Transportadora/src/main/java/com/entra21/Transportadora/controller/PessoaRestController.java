package com.entra21.Transportadora.controller;

import com.entra21.Transportadora.model.dto.Funcionario.FuncionarioDTO;
import com.entra21.Transportadora.model.dto.Pessoa.LoginDTO;
import com.entra21.Transportadora.model.dto.Pessoa.PessoaDTO;
import com.entra21.Transportadora.model.dto.Pessoa.PessoaAddDTO;
import com.entra21.Transportadora.model.dto.Pessoa.PessoaUpDTO;
import com.entra21.Transportadora.view.repository.EmpresaRepository;
import com.entra21.Transportadora.view.repository.FuncionarioRepository;
import com.entra21.Transportadora.view.service.EmpresaService;
import com.entra21.Transportadora.view.service.FuncionarioService;
import com.entra21.Transportadora.view.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private FuncionarioRepository funcionarioService;

    @Autowired
    private EmpresaRepository empresaService;
    

    @GetMapping
    public List<PessoaDTO> getPessoas() {
        return pessoaService.getAll();
    }

    @PostMapping("/login")
    public PessoaDTO getLogin(@RequestBody LoginDTO login) {
//        return new PessoaDTO(pessoaService.buscarLogin(login));

        PessoaDTO pessoaDTO = new PessoaDTO(pessoaService.buscarLogin(login));

        List<Object> pessoaDTOS = empresaService.findAll().stream().map(empresa -> {
            if(empresa.getGerente().getCpf().equals(pessoaDTO.getCpf())){
                pessoaDTO.setRole("GERENTE");
            }
            return null;
        }).collect(Collectors.toList());

        if (pessoaDTO.getRole().equals("GERENTE")){
            return pessoaDTO;
        }
        else if(funcionarioService.findByCpf(pessoaDTO.getCpf()).isPresent()){
            pessoaDTO.setRole("FUNCIONARIO");
            return pessoaDTO;
        }
        else {
            pessoaDTO.setRole("USER");
            return pessoaDTO;
        }

    }
//        if (pessoaDTO.getCpf() == null) return pessoaDTO;
//    }
//        AtomicReference<Boolean> gerenteBool = new AtomicReference<>(false);
//        empresaService.getAllEmpresas().stream().map(empresa -> {
//            if(empresa.getGerente().getCpf().equals(pessoaDTO.getCpf())){
//                gerenteBool.set(true);
//                pessoaDTO.setRole("GERENTE");
//            }
//            else {
//                pessoaDTO.setRole("GARANTE");
//            }
//            return null;
//        });
//
//        if (funcionarioService.findByCpf(new PessoaDTO(pessoaService.buscarLogin(login)).getCpf()).getCpf().equals(pessoaDTO.getCpf())){
//            pessoaDTO.setRole("FUNCIONARIO");
//            return pessoaDTO;
//        }
//
//        return pessoaDTO;
//    }

    @GetMapping("/{cpf}")
    public PessoaDTO getAllByCpf(@PathVariable(name = "cpf") String cpf) {
        return pessoaService.findByCpf(cpf);
    }

    @PostMapping("/cadastro")
    public void addPessoa(@RequestBody PessoaAddDTO newPessoa) {
        pessoaService.save(newPessoa);
    }

    @PutMapping("/{cpf}")
    public void updatePessoa(@PathVariable(name = "cpf") String cpf, @RequestBody PessoaUpDTO pessoaPayLoadDTO) {
        pessoaService.updatePessoa(cpf, pessoaPayLoadDTO);
    }

}



