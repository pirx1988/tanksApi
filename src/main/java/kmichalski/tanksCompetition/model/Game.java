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
public class Game extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(unique = true)
    private UUID gameId;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name="first_player_name")
    private String firstPlayerName;

    @Column(name="second_player_name")
    private String secondPlayerName;

    @Column(name="first_player_score")
    private Integer firstPlayerScore = 0;

    @Column(name="second_player_score")
    private Integer secondPlayerScore = 0;

    @Enumerated(EnumType.STRING)
    @Column(name="game_status")
    private GameStatus gameStatus = GameStatus.NEW;
}
