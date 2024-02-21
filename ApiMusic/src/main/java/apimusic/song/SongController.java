package apimusic.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    // todo: return not everything
    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            // todo: change http response
            return ResponseEntity.badRequest().build();
        }
        return songService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Song> saveSong(@RequestBody Song song) {
        if (song == null) {
            // todo: change http response
            return ResponseEntity.badRequest().build();
        }
        return songService.saveSong(song);
    }

    @PatchMapping("/rateSong/{id}")
    public ResponseEntity<Song> rateSong(@PathVariable(value = "id") Long songId,
                                         @RequestBody Integer rating) {
        if (songId == null || rating == null) {
            // todo: change http response
            return ResponseEntity.badRequest().build();
        }
        if (rating < 0 || rating > 5) {
            // "rating should be >= 0 and <= 5"
            return ResponseEntity.status(418).build();
        }
        return songService.rateSong(songId, rating);
    }
}
