package ru.akhramenko.P2PReview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akhramenko.P2PReview.entity.Maetrial;
import java.util.UUID;

@Repository
public interface MaterialRepo extends JpaRepository<Maetrial, UUID> {
}