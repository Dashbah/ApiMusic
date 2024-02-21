package apimusic.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public ResponseEntity<Song> findById(Long id) {
        try {
            var song = songRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(song);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Song> saveSong(Song song) {
        var newSong = songRepository.save(song);
        return ResponseEntity.ok(newSong);
    }

    public ResponseEntity<Song> rateSong(Long songId, Integer rating) {
        try {
            var song = songRepository.findById(songId).orElseThrow();
            song.setRating(
                    (song.getRating() * song.getNumOfRates() + rating)
                            / (song.getNumOfRates() + 1)
            );
            song.setNumOfRates(song.getNumOfRates() + 1);
            var newSong = songRepository.save(song);
            return ResponseEntity.ok(newSong);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
