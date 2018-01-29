package com.test.tdd;

public class Test {

  public static void main(String[] args) {

    // String input = "5,5:RFLFRFLF";
    // String input = "6,6:FFLFFLFFLFF";
    String input = "5,5:FLFLFFRFFF";
    String[] inputArray = input.split(":");
    String initCoOrdinate = inputArray[0];
    String commands = inputArray[1];
    Direction dir = Direction.N;
    int x = Integer.parseInt(initCoOrdinate.split(",")[0]);
    int y = Integer.parseInt(initCoOrdinate.split(",")[1]);
    char[] commandsArray = commands.toCharArray();
    for (char c : commandsArray) {
      Command command = Command.fromString(String.valueOf(c));
      dir = DirectionUtil.getDirection(dir, command);
      if (Command.F.equals(command)) {
        switch (dir) {
          case N:
            y = y + 1;
            break;
          case W:
            x = x - 1;
            break;
          case E:
            x = x + 1;
            break;
          case S:
            y = y - 1;
            break;

        };
      }
    }

    System.out.println("Output " + x + " " + y);
  }

  enum Command {
    F, L, R;

    public static Command fromString(String value) {
      return Enum.valueOf(Command.class, value);
    }
  }

  enum Direction {
    E, W, N, S;
  }

  static class DirectionUtil {

    public static Direction getDirection(Direction direction, Command command) {
      Direction dir = null;
      switch (direction) {
        case E:
          dir = getDirectionBasedonEast(command);
          break;
        case W:
          dir = getDirectionBasedonWest(command);
          break;
        case N:
          dir = getDirectionBasedonNorth(command);
          break;
        case S:
          dir = getDirectionBasedonSouth(command);
          break;
        default:
          break;
      }
      return dir;
    }

    public static Direction getDirectionBasedonEast(Command command) {
      Direction direction = null;
      switch (command) {
        case F:
          direction = Direction.E;
          break;
        case L:
          direction = Direction.N;
          break;
        case R:
          direction = Direction.S;
          break;

      }
      return direction;
    }

    public static Direction getDirectionBasedonWest(Command command) {
      Direction direction = null;
      switch (command) {
        case F:
          direction = Direction.W;
          break;
        case L:
          direction = Direction.S;
          break;
        case R:
          direction = Direction.N;
          break;

      }
      return direction;
    }

    public static Direction getDirectionBasedonNorth(Command command) {
      Direction direction = null;
      switch (command) {
        case F:
          direction = Direction.N;
          break;
        case L:
          direction = Direction.W;
          break;
        case R:
          direction = Direction.E;
          break;

      }
      return direction;
    }

    public static Direction getDirectionBasedonSouth(Command command) {
      Direction direction = null;
      switch (command) {
        case F:
          direction = Direction.S;
          break;
        case L:
          direction = Direction.E;
          break;
        case R:
          direction = Direction.W;
          break;
      }
      return direction;
    }

  }

}
