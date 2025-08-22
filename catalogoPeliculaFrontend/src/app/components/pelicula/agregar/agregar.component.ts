import { Component, OnInit } from '@angular/core';
import { PeliculaService } from '../../../Service/pelicula.service';
import { Router } from '@angular/router';
import { Pelicula } from '../../../Model/pelicula';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrl: './agregar.component.css'
})
export class AgregarComponent implements OnInit {

public pelicula:Pelicula = new Pelicula();
  constructor(private service: PeliculaService, private router: Router) {}

 ngOnInit(): void {
    
  }

  Guardar(pelicula:Pelicula){
    console.log(pelicula)
    console.log('Guardado')
    this.service.createPelicula(pelicula)
    .subscribe(data=>{
      alert('Se agrego corectamente ');
      this.router.navigate(['listar']);
    })
}
}
