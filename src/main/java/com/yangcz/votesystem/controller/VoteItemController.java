package com.yangcz.votesystem.controller;

import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;
import com.yangcz.votesystem.service.VoteItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteItemController {

    @Autowired
    private VoteItemService voteItemService;

    //根據Id查詢單筆投票項目
    @GetMapping("/voteitem/{itemId}")
    public ResponseEntity<VoteItem> getVoteItem(@PathVariable Integer itemId) {
        VoteItem voteItem = voteItemService.getVoteItemById(itemId);

        if(voteItem != null)
            return ResponseEntity.status(HttpStatus.OK).body(voteItem);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //查詢所有投票項目
    @GetMapping("/voteitem")
    public ResponseEntity<List<VoteItem>> getAllVoteItems() {
        List<VoteItem> voteItemList = voteItemService.getAllVoteItems();
        return ResponseEntity.ok(voteItemList);
    }

    //新增一筆投票項目
    @PostMapping("/voteitem")
    public ResponseEntity<VoteItem> createVoteItem(@RequestBody @Valid VoteItemRequest voteItemRequest) {
        Integer itemId = voteItemService.createVoteItem(voteItemRequest);

        VoteItem voteItem = voteItemService.getVoteItemById(itemId);

        return ResponseEntity.status(HttpStatus.CREATED).body(voteItem);
    }

}
