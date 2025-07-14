
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Festivos {
  private apiUrl = 'http://localhost:8080/festivos';

  constructor(private http: HttpClient) {}

  verificarFestivo(anio: number, mes: number, dia: number): Observable<string> {
    return this.http.get(`${this.apiUrl}/verificar/${anio}/${mes}/${dia}`, { responseType: 'text' });
  }

  obtenerFestivos(anio: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/obtener/${anio}`);
  }
  
}
