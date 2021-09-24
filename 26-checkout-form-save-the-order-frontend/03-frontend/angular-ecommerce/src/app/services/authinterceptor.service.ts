import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor, HttpRequest
} from '@angular/common/http';
import { from, Observable } from 'rxjs';
import {OktaAuthService} from '@okta/okta-angular';


@Injectable({
  providedIn: 'root'
})
export class AuthinterceptorService implements HttpInterceptor{

  constructor(private oktaService:OktaAuthService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   return from(this.handleAccess(req,next));
  }

  private async handleAccess(request:HttpRequest<any>,next:HttpHandler){
    const secureEndPoints= ['http://localhost:8080/api/orders'];
    if(secureEndPoints.some(url => request.urlWithParams.includes(url))){
      const accesstoken = await this.oktaService.getAccessToken();
      request = request.clone({
        setHeaders:{
          Authorization: 'Bearer '+ accesstoken
        }
      });
    }
    return next.handle(request).toPromise();
  }
}
