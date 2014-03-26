package ru.vsu.cs.zombie.server.command;

import ru.vsu.cs.zombie.server.logic.Island;

import java.util.Set;

public class GetEntitiesCommand extends Command {

    @Override
    public void execute() {
        Island island = session.getIsland();
        Command result;
        if (island != null) {
            Set<Integer> entities = island.getEntitiesID();
            result = Command.create(Command.GET_ENTITIES);
            result.parameters.put("entities", entities);
        } else {
            result = new ErrorCommand("Empty island");
        }
        session.addToWriteQueue(result);
    }
}
