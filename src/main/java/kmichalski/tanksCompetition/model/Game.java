package kmichalski.tanksCompetition.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID gameId;

    @Column
    private String name;

    @Column
    private String gameDescription;

    @Column
    private LocalDateTime time;

    @Column
    private String firstPlayerName;

    @Column
    private String secondPlayerName;

    @Column
    private Integer firstPlayerScore;

    @Column
    private Integer secondPlayerScore;

    @Enumerated(EnumType.STRING)
    @Column
    private GameStatus gameStatus;
}
