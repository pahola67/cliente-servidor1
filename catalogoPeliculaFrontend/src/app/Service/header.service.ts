import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
private titleSubject = new BehaviorSubject<string>('Catalogo');
  private showNavbarSubject = new BehaviorSubject<boolean>(true);
  
  title$ = this.titleSubject.asObservable();
  showNavbar$ = this.showNavbarSubject.asObservable();

  setTitle(title: string) {
    this.titleSubject.next(title);
  }

  showNavbar() {
    this.showNavbarSubject.next(true);
  }

  hideNavbar() {
    this.showNavbarSubject.next(false);
  }

  // Métodos específicos para cada página
  setPeliculasTitle() {
    this.setTitle('Películas');
  }

  setSeriesTitle() {
    this.setTitle('Series');
  }

  setNovedadesTitle() {
    this.setTitle('Novedades');
  }

  setMiListaTitle() {
    this.setTitle('Mi lista');
  }
}
