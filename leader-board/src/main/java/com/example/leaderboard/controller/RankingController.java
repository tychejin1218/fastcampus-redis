package com.example.leaderboard.controller;

import com.example.leaderboard.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/setScore")
    public Boolean setScore(@RequestParam String userId, @RequestParam int score) {
        return rankingService.setUserScore(userId, score);
    }

    @GetMapping("/getRank")
    public Long getRank(@RequestParam String userId) {
        return rankingService.getRank(userId);
    }

    @GetMapping("/getRanks")
    public List<String> getRanks() {
        return rankingService.getRanks(5);
    }
}