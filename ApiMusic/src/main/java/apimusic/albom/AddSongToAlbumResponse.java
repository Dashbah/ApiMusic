package apimusic.albom;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public class AddSongToAlbumResponse {
    private Long songId;
    private Long albumId;
}
