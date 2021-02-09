package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Command;

public class RedoCommand extends Command {
    public RedoCommand(ProposalController proposalController) {
        super(MessageView.REDO_COMMAND.getMessage(),proposalController);
    }

    @Override
    protected void execute() {
        this.proposalController.redo();
    }

    @Override
    protected boolean isActive() {
        return this.proposalController.redoable();
    }
}
