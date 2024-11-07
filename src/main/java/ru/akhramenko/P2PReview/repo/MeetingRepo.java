package ru.akhramenko.P2PReview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akhramenko.P2PReview.entity.Meeting;
import java.util.UUID;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, UUID>{
}
