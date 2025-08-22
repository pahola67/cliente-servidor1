package com.example.categoriaPelicula.modal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.categoriaPelicula.modal.dao.IPeliculaDao;
import com.example.categoriaPelicula.modal.entity.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired // Inyecta el repositorio
    private IPeliculaDao peliculaDao;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaDao.findById(id).orElse(null);
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaDao.findAll();
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        Pelicula peliculaExistente = peliculaDao.findById(id).orElse(null);
        if (peliculaExistente != null) {
            // Actualizar campos
            peliculaExistente.setTitulo(pelicula.getTitulo());
            peliculaExistente.setDirector(pelicula.getDirector());
            peliculaExistente.setAnio(pelicula.getAnio());
            peliculaExistente.setDuracion(pelicula.getDuracion());
            peliculaExistente.setIdioma(pelicula.getIdioma());
            peliculaExistente.setPais(pelicula.getPais());
            peliculaExistente.setFechaActualizacion(LocalDateTime.now());
            return peliculaDao.save(peliculaExistente);
        }
        return null;
    }

    @Override
    public void eliminarPelicula(Long id) {
        peliculaDao.deleteById(id);
    }

}
