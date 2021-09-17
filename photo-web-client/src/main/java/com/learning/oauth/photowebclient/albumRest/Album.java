package com.learning.oauth.photowebclient.albumRest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Album{
    String albumId;
    String albumTitle;
    long releaseDate;

}
