package apimusic.albom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PutMapping(params = {"name"})
    public ResponseEntity<Album> saveAlbum(@RequestParam("name") String albumName) {
        if (albumName == null) {
            // todo: change http response
            return ResponseEntity.badRequest().build();
        }
        return albumService.saveNewAlbum(albumName);
    }

    @PatchMapping(params = {"albumId", "songId"})
    public ResponseEntity<Album> addSongToAlbum(@RequestParam Long albumId, @RequestParam Long songId) {
        if (albumId == null || songId == null) {
            // todo: change http response
            return ResponseEntity.badRequest().build();
        }
        return albumService.addSongToAlbum(songId, albumId);
    }
}
