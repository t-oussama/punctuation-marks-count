import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PunctuationCountDTO } from '../../dto/puctuation-count-dto';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class PunctuationCountService {

  SERVICE_URL = environment.api_url;
  constructor(private http: HttpClient) { }

  countPunctuation(text): Observable<PunctuationCountDTO> {
    return this.http.post<PunctuationCountDTO>(this.SERVICE_URL, text);
  }

}
