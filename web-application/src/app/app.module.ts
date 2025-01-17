import { NgModule, Pipe } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LocalizadorComponent } from './logado/localizador/localizador.component';
import { ConfiguracoesComponent } from 'src/app/logado/configuracoes/configuracoes.component';
import { FooterComponent } from 'src/app/sharepage/footer/footer.component';
import { ContactComponent } from '../pages/contact/contact.component';
import { HomeComponent } from 'src/pages/home/home.component';
import { AboutComponent } from 'src/pages/about/about.component';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BasicAuthInterceptor } from './logado/helpers/basic-auth.interceptor';
import { LoginComponent } from 'src/pages/login/login.component';
import { CadastroComponent } from 'src/pages/login/cadastro/cadastro.component';
import { FuncionariosComponent } from './funcionarios/funcionarios.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { EntregasItemDetalhesComponent } from './entregas-item-detalhes/entregas-item-detalhes.component';
import { ItemComponent } from './item/item.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ContactComponent,
    LoginComponent,
    HomeComponent,
    AboutComponent,
    LocalizadorComponent,
    ConfiguracoesComponent,
    CadastroComponent,
    FuncionariosComponent,
    EntregasItemDetalhesComponent,
    ItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}, {provide: HTTP_INTERCEPTORS, useClass:BasicAuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }







