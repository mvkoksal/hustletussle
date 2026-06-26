package io.github.mvkoksal.hustleTusslePlugin;

public class GetGameState {
    public enum GameState {
        WAITING,
        IN_PROGRESS,
        ENDED
    }
    public static GameState currentGameState = GameState.WAITING;

}

