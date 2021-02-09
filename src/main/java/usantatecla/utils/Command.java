package usantatecla.utils;

import usantatecla.mastermind.controllers.ProposalController;

public abstract class Command {

    protected String title;
    protected ProposalController proposalController;

    public Command(String title, ProposalController proposalController) {
        this.title = title;
        this.proposalController = proposalController;
    }

    protected abstract void execute();

    protected abstract boolean isActive();

    public String getTitle() {
        return title;
    }

}
