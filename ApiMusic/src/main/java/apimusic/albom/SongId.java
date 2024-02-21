package apimusic.albom;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class SongId {
    @Id
    private Long id;

    @JsonProperty("userIdValue")
    private Long value;

    public SongId(Long id) {
        value = id;
    }
}
