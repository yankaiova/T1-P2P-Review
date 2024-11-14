package ru.akhramenko.P2PReview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akhramenko.P2PReview.entity.User;
import ru.akhramenko.P2PReview.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable UUID id) {
        return commentService.findById(id);
    }

    @GetMapping("/meeting_id={meeting_id}")
    @Operation(summary = "Получение комментов по id встречи")
    public List<Comment> findAllCommentsByMeeting(@RequestParam UUID meeting_id) {
        return commentService.findByMeeting(_id);
    }


    @PostMapping("")
    public Comment addNewComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable UUID id) {
        commentService.delete(id);
    }

}