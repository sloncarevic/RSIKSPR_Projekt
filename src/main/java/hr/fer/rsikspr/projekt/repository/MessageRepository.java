package hr.fer.rsikspr.projekt.repository;

import hr.fer.rsikspr.projekt.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
