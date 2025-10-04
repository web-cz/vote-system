package com.yangcz.votesystem.controller;

import com.yangcz.votesystem.common.dto.VoteItemRequest;
import com.yangcz.votesystem.common.model.VoteItem;
import com.yangcz.votesystem.service.VoteItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
        return ResponseEntity.status(HttpStatus.OK).body(voteItemList);
    }

    //新增一筆投票項目
    @PostMapping("/voteitem")
    public ResponseEntity<VoteItem> createVoteItem(@RequestBody @Valid VoteItemRequest voteItemRequest) {
        Integer itemId = voteItemService.createVoteItem(voteItemRequest);
        VoteItem voteItem = voteItemService.getVoteItemById(itemId);
        return ResponseEntity.status(HttpStatus.CREATED).body(voteItem);
    }

    //修改一筆投票項目
    @PutMapping("/voteitem/{itemId}")
    public ResponseEntity<VoteItem> updateVoteItem(@PathVariable @NotNull Integer itemId,
                                                   @RequestBody @Valid VoteItemRequest voteItemRequest) {
        voteItemService.updateVoteItem(itemId, voteItemRequest);
        VoteItem updatedVoteItem = voteItemService.getVoteItemById(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedVoteItem);
    }

}
