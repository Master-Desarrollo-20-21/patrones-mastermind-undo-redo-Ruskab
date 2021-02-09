package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.List;

public class Session {

    private Game game;
    private GameRegistry registry;
    private State state;

    public Session() {
        this.game = new Game();
        this.registry = new GameRegistry(this.game);
        this.state = new State();
    }

    public Game getGame() {
        return game;
    }
    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
        this.registry.register();
    }

    public boolean isEndGame() {
        return this.game.isWinner() || this.game.isLooser();
    }

    public void next() {
        this.state.next();
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public void clear() {
        this.game.clear();
        this.state.reset();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.isRedoable();
    }

    public boolean undoable() {
        return this.registry.isUndoable();
    }
}
