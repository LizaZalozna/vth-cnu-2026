package ua.cdu.edu.fotius.fspm.valorant.analytics.domain.model;

import ua.cdu.edu.fotius.fspm.valorant.analytics.domain.exception.DomainException;

public record UserScore(String playerId, int kills, int deaths, int assists, int combatScore, boolean isAfk) {
    public UserScore {
        if (playerId == null || playerId.isBlank()) {
            throw new DomainException("INVALID_PLAYER_ID", "Player Id cannot be blank");
        }

        if (kills < 0 || deaths < 0 || assists < 0 || combatScore < 0) {
            throw new DomainException("INVALID_USER_SCORE", "User score cannot be negative");
        }
    }
}
