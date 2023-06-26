package hr.fer.rsikspr.projekt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    @Column(nullable = false)
    private LocalDateTime time;
    @JsonProperty("from")
    @Column(nullable = false)
    private String sender;
    @JsonProperty("to")
    @Column(nullable = false)
    private String recipient;
    @JsonProperty("text")
    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @Column(nullable = false)
    private Long chatID;

}
