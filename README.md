# 🍳 CookOff Arena

A real-time Cooking Battle PvP game built with **Java (OOP), JavaFX UI, and Socket Networking**.

---

## 🎮 Overview

CookOff Arena is a competitive cooking game where players race against each other (or AI) to complete recipes under time pressure.

Players must:

* Follow recipe steps in the correct order
* Optimize speed and accuracy
* Compete in a turn-based PvP system

---

## 🚀 Features

* 👥 PvP Multiplayer (Socket-based)
* 🤖 AI Opponent (Strategy Pattern)
* 🎯 Rule-based Cooking System
* 📊 Weighted Scoring System
* 🎮 Drag & Drop UI (JavaFX)
* ⏱️ Time Pressure Mechanics

---

## 🧠 OOP Concepts Applied

* **Encapsulation**

  * `GameState`, `Dish`, `Player`
* **Inheritance**

  * `Player` → `HumanPlayer`, `AIPlayer`
* **Polymorphism**

  * `makeMove()`, `Judge.score()`
* **Abstraction**

  * `Judge`, `AIStrategy`

---

## 🧩 Design Patterns

* Strategy Pattern → AI behavior (`AIStrategy`)
* Composite Pattern → Scoring (`FinalJudge`)
* Separation of Concerns → UI / Logic / Network

---

## 🏗️ Project Structure

```
src/
 ├── app/
 ├── core/
 ├── domain/
 ├── scoring/
 ├── ui/
 ├── network/
 ├── util/
 └── data/
```

---

## ⚙️ How to Run

### 1. Run Server

```
java network.server.GameServer
```

### 2. Run Client

```
java ui.MainApp
```

---

## 🎯 Game Flow

1. Start Game
2. Player takes turn
3. Validate move (RuleEngine)
4. Update GameState
5. Calculate score
6. Repeat until game ends

---

## 📊 Scoring Formula

```
Score = Accuracy * 5 + Speed * 3 + Completion * 10
```

---

## 🌐 Multiplayer Architecture

* Client sends moves → Server
* Server validates & syncs state
* Broadcast updates to players

---

## ⚠️ Challenges

* Synchronizing game state in multiplayer
* Handling drag & drop UI events
* Designing scalable OOP architecture

---

## 🚀 Future Improvements

* Online matchmaking
* Advanced AI
* Animation & sound effects
* Replay system

---

## 👨‍💻 Team

* 3 Developers
* Built for OOP Project

---

## ⭐ Final Note
This project demonstrates a complete application of **OOP principles, design patterns, and real-time interaction** in a game environment.
