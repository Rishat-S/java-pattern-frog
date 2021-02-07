package ru.netology;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .redo(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public boolean redo() {

                return frog.jump(steps);
            }

            @Override
            public boolean undo() {

                return frog.jump(-steps);
            }
        };
    }

}
