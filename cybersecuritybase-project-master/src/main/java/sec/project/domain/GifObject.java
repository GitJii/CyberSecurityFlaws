package sec.project.domain;
 
import javax.persistence.Entity;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class GifObject extends AbstractPersistable<Long> {
 
    @Lob
    private byte[] content;
 
}