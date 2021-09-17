package com.learning.oauth.photowebclient.controller;

import com.learning.oauth.photowebclient.albumRest.Album;
import com.nimbusds.openid.connect.sdk.token.OIDCTokens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class AlbumController {

    @GetMapping("/albums")
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
        log.info("Request for album received: ",principal);
        if(principal==null){
            log.info("Principle is null");
        }

        Album al1 = new Album("1234", "Faded", 21);
        Album al2 = new Album("124", "Moon Walk", 23);

        model.addAttribute("albums",Arrays.asList(al1,al2));
        log.info("new str");
        OidcIdToken idToken = principal.getIdToken();
        String idTokenValue = idToken.getTokenValue();
       log.info(idTokenValue);
       log.info("s");
        return "albums";
    }
}
