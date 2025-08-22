import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/usuario/login/login.component';
import { RegistroComponent } from './components/usuario/registro/registro.component';
import { HeaderComponent } from './components/nav/header/header.component';
import { AuthGuard } from './components/usuario/guards/auth.guard';
import { ListarComponent } from './components/pelicula/listar/listar.component';
import { AgregarComponent } from './components/pelicula/agregar/agregar.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'catalogo', component: HeaderComponent, canActivate: [AuthGuard] },
  { path: 'listar', component: ListarComponent},
  { path: 'agregar', component: AgregarComponent},
    { path: '', redirectTo: '/listar', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
