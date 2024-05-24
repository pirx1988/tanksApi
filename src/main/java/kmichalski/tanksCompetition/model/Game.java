package kmichalski.tanksCompetition.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(min = 3, max = 100, message = "Second player name must be between 3 and 100 characters")
    private String firstPlayerName;

    @NotNull
    @Size(min = 3, max = 100, message = "Second player name must be between 3 and 100 characters")
    @Column(name="second_player_name")
    private String secondPlayerName;

    @Column(name="first_player_score")
    @Min(value = 0, message = "First player Game score must be bigger or equal than zero")
    private Integer firstPlayerScore = 0;

    @Column(name="second_player_score")
    @Min(value = 0, message = "Second player Game score must be bigger or equal than zero")
    private Integer secondPlayerScore = 0;

    @Enumerated(EnumType.STRING)
    @Column(name="game_status")
    private GameStatus gameStatus = GameStatus.NEW;
}
