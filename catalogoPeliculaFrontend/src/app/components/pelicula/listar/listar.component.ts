import { Component, OnInit } from '@angular/core';
import { PeliculaService } from '../../../Service/pelicula.service';
import { Pelicula } from '../../../Model/pelicula';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css'
})
export class ListarComponent implements OnInit {

  peliculas: Pelicula[] = [];

  constructor(private Service: PeliculaService) {}

  ngOnInit(): void {
    this.cargarPeliculas();
  }

  cargarPeliculas() {
    this.Service.getPeliculas().subscribe(data => {
      this.peliculas = data;
    });
  }

  editarPelicula(pelicula: Pelicula) {
    console.log("Editar:", pelicula);
    // aquí rediriges al formulario o abres un modal
  }

  eliminarPelicula(id: number) {
    if (confirm("¿Seguro que deseas eliminar esta película?")) {
      this.Service.deletePelicula(id).subscribe(() => {
        this.cargarPeliculas();
      });
    }
  }

}
