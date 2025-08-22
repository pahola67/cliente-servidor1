package com.example.categoriaPelicula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.categoriaPelicula.modal.entity.Pelicula;
import com.example.categoriaPelicula.modal.service.IPeliculaService;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "http://localhost:4200")
public class PeliculaController {
	
	@Autowired
    private IPeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPelicula(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id);
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.crearPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.actualizarPelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
    }

}
