package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.mastermind.views.console.AttemptsView;
import usantatecla.mastermind.views.console.ErrorView;
import usantatecla.mastermind.views.console.ProposedCombinationView;
import usantatecla.mastermind.views.console.ResultView;
import usantatecla.mastermind.views.console.SecretCombinationView;
import usantatecla.utils.Command;
import usantatecla.utils.Console;

import java.util.List;

public class ProposalCommand extends Command {
    public ProposalCommand(ProposalController proposalController) {
        super(MessageView.ACTION_COMMAND.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        Error error;
        do {
            List<Color> colors = new ProposedCombinationView(proposalController).read();
            error = proposalController.addProposedCombination(colors);
            if (error != null) {
                new usantatecla.mastermind.views.console.ErrorView(error).writeln();
            }
        } while (error != null);
        Console.instance().writeln();
        new AttemptsView(proposalController).writeln();
        new SecretCombinationView(proposalController).writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController).write(i);
            new ResultView(proposalController).writeln(i);
        }
        if (proposalController.isWinner()) {
            Console.instance().writeln(MessageView.WINNER.getMessage());
        } else if (proposalController.isLooser()) {
            Console.instance().writeln(MessageView.LOOSER.getMessage());
        }

    }

    @Override
    protected boolean isActive() {
        return true;
    }
}
