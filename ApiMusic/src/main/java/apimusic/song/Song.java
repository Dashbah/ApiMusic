package apimusic.song;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// todo: check required annotations
@Entity
@Table(name = "songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String singer;
    private Type type;
    // in seconds
    private Long duration;
    // @ONeTo..
    private int albumId;
    private double rating;
    private Long numOfRates;
}
