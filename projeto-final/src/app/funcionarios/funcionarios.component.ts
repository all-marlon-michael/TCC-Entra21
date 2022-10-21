import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { Funcionarios } from 'types/types';
import { FuncionarioRestController } from '../Rest/funcionarios.rest';

@Component({
  selector: 'app-funcionarios',
  templateUrl: './funcionarios.component.html',
  styleUrls: ['./funcionarios.component.css']
})
export class FuncionariosComponent implements OnInit {

  loading = false;
  funcionarios: Funcionarios[] = [];
submitted = false;
returnUrl: string = this.route.snapshot.queryParams['returnUrl'];
error = '';
succes = false;
inserting = false;

funcionariobuscar: Funcionarios[] = [];
  form: FormGroup;
  constructor(private funcionarioRestController: FuncionarioRestController, 
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,) { 
      this.form = this.formBuilder.group({
        nome: ['',Validators.required ],
        sobrenome: ['',Validators.required] ,
        cpf: ['',Validators.required ]
        // '', Validators.required
      });
    }
  // ngOnInit(): void {
  //   throw new Error('Method not implemented.');
  // }
  ngOnInit() {
    this.loading = true;
    this.funcionarioRestController.getAll().pipe(first()).subscribe((funcionarios: any) => {
        this.loading = false;
        this.funcionarios = funcionarios;
    });
  
  }

  onSearch(){
    this.funcionarioRestController.getbycnpj().pipe(first()).subscribe((funcionariobuscar: Funcionarios[]) => { 
      console.log(this.funcionariobuscar.values);
    // },
    // error: (console.error();
    // ) => console.log(Error),
  });
}


  // onDelete() {
    
  // }// onAdd(){// }// onSubmit(){// onCancel(// }// onEdit(){
  //     this.edit.emit(this.funcionarios);

  // }

//   @Input() funcionario!: Funcionarios;
//   @Output() funcionarioDelete = new EventEmitter<Funcionarios>();
//   // @Output() heroEdit = new EventEmitter<number>();
//   @Output() funcionarioEdit = new EventEmitter<string>();


//   onDelete = () => {
//     this.funcionarioDelete.emit(this.funcionario);
//   }

//   onEdit = () => {
//     this.funcionarioEdit.emit(this.funcionario.cpf),
//     this.funcionarioEdit.emit(this.funcionario.nome),
//     this.funcionarioEdit.emit(this.funcionario.sobrenome);
//   }

// // editingFuncionario: Funcionario | null | undefined = null;
// inserirFuncionario = () => {
//     this.funcionarioEdit;
//     this.inserting = true;
//   } 

//   // save = (funcionario: Funcionarios) => {
//   //   if (funcionario.cpf == null) {
//   //     funcionario.cpf = (
//   //       this.funcionario.length > 0 ? 
//   //       this.funcionario.map((h: Funcionarios) => h.cpf!)
//   //       .sort()[this.funcionario.length-1] : 0)+1
//   //     this.funcionario.push(funcionario)
//   //   } else {
//   //     let pos = this.funcionario.findIndex((h: Funcionarios) => h.cpf! == funcionario.cpf!)
//   //     this.funcionario[pos] = funcionario;
//   //   }
//   // }

//   remove = (funcionario: Funcionarios) => {
//     funcionario = funcionario.filter((h: Funcionarios) => h.cpf! != funcionario.cpf!);
//   }
  
// //   edit = (funcionarioCPF: string) => {
// //     this.funcionarioEdit = this.funcionario.find((h: Funcionarios) => h.cpf! == funcionarioCPF!).push;
// //     this.inserting = true;
// // }

// @Input() editingFuncionario? : Funcionarios | null | undefined;
//   @Output() insertChange = new EventEmitter<boolean>();
//   @Output() FuncionarioSave = new EventEmitter<Funcionarios>();

//   ngOnChanges(changes: SimpleChanges): void {
//     this.form.reset();
//     this.form.patchValue(changes["editingHero"].currentValue);
//   }

//   cancel = () => {
//     this.insertChange.emit(false);
//   }

//   onSubmit = () => {
//     this.FuncionarioSave.emit(this.form.value as Funcionarios);
//     this.form.reset();
//     this.cancel();
//   }


}