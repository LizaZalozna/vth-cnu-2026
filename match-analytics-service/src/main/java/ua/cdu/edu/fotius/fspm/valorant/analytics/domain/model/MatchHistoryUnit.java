package ua.cdu.edu.fotius.fspm.valorant.analytics.domain.model;

public record MatchHistoryUnit(
        String matchId,
        String mapName,
        bool isWin,
        int deltaRR,
        String tierStatus
) {}