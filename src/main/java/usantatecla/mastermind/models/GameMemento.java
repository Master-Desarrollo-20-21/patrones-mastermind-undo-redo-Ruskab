package usantatecla.mastermind.models;

import java.util.List;

public class GameMemento {

    private int attempts;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public GameMemento(int attempts, List<ProposedCombination> proposedCombinations, List<Result> results) {
        this.attempts = attempts;
        this.proposedCombinations = proposedCombinations;
        this.results = results;
    }


    public int getAttempts() {
        return attempts;
    }

    public List<ProposedCombination> getProposedCombinations() {
        return proposedCombinations;
    }

    public List<Result> getResults() {
        return results;
    }
}
