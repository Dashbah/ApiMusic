package apimusic.albom;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
public class Album {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<SongId> songIds;

    public Album(String albumName) {
        name = albumName;
    }
}
