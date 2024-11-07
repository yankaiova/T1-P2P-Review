package ru.akhramenko.P2PReview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akhramenko.P2PReview.entity.Change;
import java.util.UUID;

@Repository
public interface ChangeRepo extends JpaRepository<Change, UUID> {
}
