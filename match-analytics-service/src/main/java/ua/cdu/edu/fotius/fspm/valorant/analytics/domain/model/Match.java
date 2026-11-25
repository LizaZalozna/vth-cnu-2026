package ua.cdu.edu.fotius.fspm.valorant.analytics.domain.model;

import ua.cdu.edu.fotius.fspm.valorant.analytics.domain.exception.DomainException;

import java.util.Objects;

public class Match {
    private final MatchId id;
    private final String rosterId;
    private final String mapName;
    private final boolean isWin;
    private final int roundMargin;
    private final UserScore score;
    private final int deltaRR;
    private final String tierStatus;

    public Match(MatchId id, String rosterId, String mapName,
                 boolean isWin, int roundMargin, CombatScore score, int deltaRR, String tierStatus) {
        if (rosterId == null || rosterId.isBlank()) {
            throw new DomainException("INVALID_ROSTER_ID", "Roster id is required");
        }
        if (mapName == null || mapName.isBlank()) {
            throw new DomainException("INVALID_MAP_NAME", "Map name is required");
        }
        if (roundMargin < 0) {
            throw new DomainException("INVALID_ROUND_MARGIN", "Round margin cannot be negative");
        }
        if (tierStatus == null || tierStatus.isBlank()) {
            throw new DomainException("INVALID_TIER_STATUS", "Tier status is required");
        }

        this.id = Objects.requireNonNull(id);
        this.rosterId = rosterId.trim();
        this.mapName = mapName.trim();
        this.isWin = isWin;
        this.roundMargin = roundMargin;
        this.score = Objects.requireNonNull(score);
        this.deltaRR = deltaRR;
        this.tierStatus = tierStatus.trim();
    }

    public MatchId getId() { return id; }
    public String getRosterId() { return rosterId; }
    public String getMapName() { return mapName; }
    public boolean isWin() { return isWin; }
    public int getRoundMargin() { return roundMargin; }
    public CombatScore getScore() { return score; }
    public int getDeltaRR() { return deltaRR; }
    public String getTierStatus() { return tierStatus; }
}
