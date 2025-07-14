import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Festivos } from '../servicios/festivos';

@Component({
  selector: 'app-validar-fecha',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule
  ],
  templateUrl: './validar-fecha.html',
  styleUrls: ['./validar-fecha.css']
})
export class ValidarFechaComponent {
  fechaSeleccionada: Date | null = null;
  resultado: string | null = null;

  constructor(private festivosService: Festivos) {}

  validarFecha() {
    if (!this.fechaSeleccionada) {
      this.resultado = 'Por favor selecciona una fecha';
      return;
    }
    const anio = this.fechaSeleccionada.getFullYear();
    const mes = this.fechaSeleccionada.getMonth() + 1;
    const dia = this.fechaSeleccionada.getDate();
    this.festivosService.verificarFestivo(anio, mes, dia).subscribe({
      next: (res) => this.resultado = res,
      error: () => this.resultado = 'Error consultando la API'
    });
  }
}
