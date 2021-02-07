package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Frog
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Frog frog = new Frog();
        List<FrogCommand> commands = new LinkedList<>();
        int curCommand = -1;
        String lastInput = null;

        while (true) {

            frog.draw();

            System.out.println("+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "<< - Undo (отмени последнюю команду)\n" +
                    ">> - Redo (повтори отменённую команду)\n" +
                    "!! - повтори последнюю команду\n" +
                    "0 - выход");

            //считываем ввод и конструируем команду, если
            //пользователь не хотел выйти

            String input = null;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if (input == null) {
                continue;
            }

            if (input.equals("0")) {
                break;
            }

            if (input.equals("!!") && curCommand == -1) {
                System.out.println("Нечего повторять!");
                continue;
            }
            if (input.equals("!!")) {
                input = lastInput;
            }

            if (input.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (input.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).redo();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                    commands.subList(curCommand + 1, commands.size()).clear();
                }

                try {
                    FrogCommand cmd = FrogCommands.jumpCommand(frog, Integer.parseInt(input));
                    curCommand++;
                    commands.add(cmd);
                    cmd.redo();
                } catch (NumberFormatException e) {
                    System.out.println("Команда не распознана!");
                    input = lastInput;
                    System.out.println(e.getMessage());
                }
            }
            lastInput = input;
        }
    }
}
