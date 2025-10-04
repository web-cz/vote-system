package com.yangcz.votesystem.controller;

import com.yangcz.votesystem.dto.VoteRecordRequest;
import com.yangcz.votesystem.model.VoteItem;
import com.yangcz.votesystem.service.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;

    //投票
    @PostMapping("vote/{itemId}")
    public ResponseEntity<String> vote(@PathVariable Integer itemId,
                                       @RequestBody @Valid VoteRecordRequest voteRecordRequest) {
        voteService.vote(itemId, voteRecordRequest);
        return ResponseEntity.status(HttpStatus.OK).body("投票成功");
    }


}

