
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

cadastroForm: FormGroup = this.formBuilder.group({
  nome: ['', Validators.required],
  sobrenome: ['', Validators.required],
  telefone: ['', Validators.required],
  cpf: ['', Validators.required],
  login: ['', Validators.required],
  senha: ['', Validators.required]
});
loading = false;
submitted = false;
returnUrl: string = this.route.snapshot.queryParams['returnUrl'];
error = '';
succes = false;


constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
){}
get f() {
  return this.cadastroForm.controls;
} 

cadastrar() {
  this.submitted = true;
  if (this.cadastroForm.invalid) {
      return;
  }
  console.log(this.cadastroForm.value);
  this.http.post<any>('/pessoa/cadastro', this.cadastroForm.value)
    .subscribe({
      next: (response) => {
        console.log(response);
        this.router.navigateByUrl('/login');
      },
      error: (error) => console.log(error),
    });
}}