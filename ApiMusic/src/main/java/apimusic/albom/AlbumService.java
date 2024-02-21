package apimusic.albom;

import apimusic.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public ResponseEntity<Album> saveNewAlbum(String albumName) {
        var newAlbum = albumRepository.save(new Album(albumName));
        return ResponseEntity.ok(newAlbum);
    }

    public ResponseEntity<Album> addSongToAlbum(Long songId, Long albumId) {
        try {
            var album = albumRepository.findById(albumId).orElseThrow();
            var song = songRepository.findById(songId).orElseThrow();
            album.getSongIds().add(new SongId(song.getId()));
            var newAlbum = albumRepository.save(album);
            return ResponseEntity.ok(newAlbum);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
