package com.entra21.Transportadora.model.dto.Funcionario;

import com.entra21.Transportadora.model.dto.Empresa.EmpresaAddDTO;
import com.entra21.Transportadora.model.dto.Entrega.EntregaAddDTO;
import com.entra21.Transportadora.model.dto.Pessoa.PessoaAddDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class FuncionarioAddDTO extends PessoaAddDTO {
    private FuncionarioAddDTO supervisor;
    private List<EntregaAddDTO> entrega;
    private EmpresaAddDTO empresa;
}
