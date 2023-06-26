package hr.fer.rsikspr.projekt.repository;

import hr.fer.rsikspr.projekt.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByClientID(String clientID);
    Optional<Chat> findFirstByClientIDOrderByStartTimeDesc(String clientID);
}
