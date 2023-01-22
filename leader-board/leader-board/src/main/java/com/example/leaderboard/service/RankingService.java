package com.example.leaderboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RankingService {

    private static final String LEADER_BOARD = "leaderBoard";

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 점수 생성 및 업데이트
     */
    public boolean setUserScore(String userId, int score) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(LEADER_BOARD, userId, score);
        return true;
    }

    /**
     * 특정 대상 순위 조회(값 기반 조회)
     */
    public Long getRank(String userId) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long rank = zSetOperations.reverseRank(LEADER_BOARD, userId);
        return rank;
    }

    /**
     * 상위 랭크 조회(범위 기반 조회)
     */
    public List<String> getRanks(int limit) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set<String> rangeSet = zSetOperations.reverseRange(LEADER_BOARD, 0, limit - 1);
        return new ArrayList<>(rangeSet);
    }
}
