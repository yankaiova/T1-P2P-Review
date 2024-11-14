package ru.akhramenko.P2PReview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.P2PReview.entity.Comment;
import ru.akhramenko.P2PReview.repo.CommentPero;
import ru.akhramenko.P2PReview.utils.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;

    public Comment findById(UUID id) {
        return commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Comment create(Comment comment) {
        User createdComment = new Comment();
        createdComment.setComment_id(UUID.randomUUID());
        createdComment.setComment_user(comment.getUserId());//сохранять id user, comment text и user id
        return commentRepo.save(createdComment);
    }

   @Transactional
   public List<Comment> findByMeeting(UUID meeting_id) {
       return commentRepo.findByMeetingId(meeting_id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void delete(UUID id) {
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepo.delete(material);
    }
}