import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { Festivos } from '../servicios/festivos';

@Component({
  selector: 'app-lista-festivos',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    MatTableModule
  ],
  templateUrl: './lista-festivos.html',
  styleUrls: ['./lista-festivos.css']
})
export class ListaFestivosComponent {
  anio: number = new Date().getFullYear();
  festivos: any[] = [];
  columns = [
    { prop: 'festivo', name: 'Festivo' },
    { prop: 'fecha', name: 'Fecha' }
  ];

  constructor(private festivosService: Festivos) {}

  obtenerFestivos() {
    this.festivosService.obtenerFestivos(this.anio).subscribe({
      next: (data: any[]) => {
        this.festivos = data;
      },
      error: (err) => {
        this.festivos = [];
        alert('Error al obtener festivos: ' + err.message);
      }
    });
  }

}
