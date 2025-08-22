import { Component, OnDestroy, OnInit } from '@angular/core';
import { HeaderService } from './Service/header.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'catalogoPelicula';
 currentTitle: string = 'Catalogo';
  showNavbar: boolean = true;
  
  private titleSubscription!: Subscription;
  private navbarSubscription!: Subscription;
isNavbarVisible: any;

  constructor(public headerService: HeaderService) {}

  ngOnInit() {
    // Suscribirse a los cambios de título
    this.titleSubscription = this.headerService.title$.subscribe(title => {
      this.currentTitle = title;
    });

    // Suscribirse a los cambios de visibilidad del navbar
    this.navbarSubscription = this.headerService.showNavbar$.subscribe(show => {
      this.showNavbar = show;
    });
  }

  ngOnDestroy() {
    // Limpiar suscripciones
    if (this.titleSubscription) {
      this.titleSubscription.unsubscribe();
    }
    if (this.navbarSubscription) {
      this.navbarSubscription.unsubscribe();
    }
  }
}
