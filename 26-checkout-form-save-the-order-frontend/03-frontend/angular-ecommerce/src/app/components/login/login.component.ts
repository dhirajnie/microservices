import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import * as OktaSignIn from '@okta/okta-signin-widget';

import myAppConfig from '../../config/my-app-config';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  oktaSignIn: any;

  constructor(private oktaAuthService:OktaAuthService) { 
    this.oktaSignIn = new OktaSignIn({
      logo: 'src/assets/images/logo.png',
      features:{
        registration:true
      },
      baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
      clientId: myAppConfig.oidc.clientId,
      redirectUri: myAppConfig.oidc.redirectUri,
      authParams: {
        pkce: true,
        issuer: myAppConfig.oidc.issuer,
        scope: myAppConfig.oidc.scopes
      }
    });


  }


  ngOnInit(): void {
    this.oktaSignIn.remove();
    this.oktaSignIn.renderEl({
      el:"#okta-sign-in-widget"
    },
    (response)=>{
      if(response.status=='SUCCESS'){
        this.oktaAuthService.signInWithRedirect();
      }
    });
   




  }

}
