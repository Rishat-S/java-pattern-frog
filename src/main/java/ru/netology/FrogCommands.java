package ru.netology;

public class FrogCommands {
    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .redo(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public void redo() {

                frog.jump(steps);
            }

            @Override
            public void undo() {

                frog.jump(-steps);
            }
        };
    }

}
