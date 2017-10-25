package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.commons.events.ui.SwitchToContactsListEvent;

/**
 * Lists all persons in the address book to the user by their email.
 */
public class SortByEmail extends Command {

    public static final String COMMAND_WORD = "email";
    public static final String COMMAND_ALIAS = "em";

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    public SortByEmail() { eventsCenter.registerHandler(this); }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        raise(new SwitchToContactsListEvent());
        model.sortPersonListByEmail();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
