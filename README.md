# CookOff Arena

CookOff Arena is a Java OOP game where two players (Human vs Human or Human vs AI) cook and compete on score.

## OOP + SOLID Focus

- Encapsulation: internal player data and domain state are hidden behind methods.
- Inheritance and polymorphism: `IPlayer`, `IJudge`, `IAIStrategy` allow runtime behavior changes.
- Abstraction: UI, battle, scoring, and data loading are separate concerns.
- SOLID:
  - SRP: each class has a single responsibility.
  - OCP: add new judges/strategies without changing core flow.
  - LSP: `HumanPlayer` and `AIPlayer` are interchangeable as `IPlayer`.
  - ISP: small interfaces (`IPlayer`, `IJudge`, `IAIStrategy`).
  - DIP: `BattleSession` depends on `IJudge` and `Timer` abstractions/injected dependencies.

## Project Structure

Matches your requested package architecture:

- `core`: game loop, state, event bus
- `domain`: pure models
- `player`: player classes + AI strategy pattern
- `battle`: session/timer/leaderboard + judge pattern
- `ui`: menu and battle rendering
- `infrastructure`: recipe loading from JSON

## Run

### Maven

```bash
mvn clean test
mvn exec:java
```

### Gradle

```bash
gradle test
gradle run
```

## Notes

- Recipes are loaded from `src/main/resources/recipes.json`.
- If loading fails, app falls back to default in-code recipes.
- Current gameplay supports:
  - multi-round match (1-5 rounds)
  - replay loop (`Play again?`)
  - switchable judge mode: `ScoreJudge`, `TimeJudge`, `CompositeJudge`

## Report-Ready SOLID Mapping

### SRP (Single Responsibility)

- `RecipeLoader` only loads recipe data.
- `BattleSession` only runs a round and creates result objects.
- `MenuUI` only handles user input flow.

### OCP (Open/Closed)

- Add new scoring behavior by creating another `IJudge` implementation.
- Add new AI behavior by creating another `IAIStrategy` implementation.
- Core loop does not change when new implementations are added.

### LSP (Liskov Substitution)

- `HumanPlayer` and `AIPlayer` are both used through `IPlayer` in `GameLoop`.
- `ScoreJudge`, `TimeJudge`, and `CompositeJudge` are interchangeable via `IJudge`.

### ISP (Interface Segregation)

- `IPlayer` exposes only battle-relevant player methods.
- `IJudge` exposes only `evaluate`.
- `IAIStrategy` focuses only recipe decision and ingredient selection.

### DIP (Dependency Inversion)

- `BattleSession` receives `IJudge` from outside (injection at call site).
- `GameLoop` depends on abstractions (`IPlayer`, `IJudge`, `IAIStrategy`) instead of concrete internals.

## Class Diagram Alignment Notes

- Player layer and strategy pattern are fully represented:
  - `IPlayer`, `HumanPlayer`, `AIPlayer`, `IAIStrategy`, `EasyStrategy`, `HardStrategy`.
- Battle engine and judge layer are represented:
  - `BattleSession`, `Timer`, `Leaderboard`, `IJudge`, `ScoreJudge`, `TimeJudge`.
- Added `AbstractJudge` and `CompositeJudge` to better match abstraction + polymorphic extension in UML direction.
