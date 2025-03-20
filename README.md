# Tic-Tac-Toe (Java Console Game)

Ein einfaches Tic-Tac-Toe-Spiel als **Konsolenanwendung** in Java.

## Installation

1. **Repository klonen:**
   ```sh
   git clone https://github.com/RinChise/tictactoe.git
   ```
2. **Projekt in einer Java-IDE (z. B. IntelliJ, Eclipse) öffnen** oder über die Konsole kompilieren:
   ```sh
   javac TicTacToe.java
   ```
3. **Spiel starten:**
   ```sh
   java TicTacToe
   ```

## Spielablauf

1. **Spielernamen eingeben**
    - Jeder Spieler gibt seinen Namen ein.
    - Spieler 1 spielt mit **X**, Spieler 2 mit **O**.
  
![Bildschirmfoto vom 2025-03-20 08-57-56](https://github.com/user-attachments/assets/9a2a717f-3209-4f7b-8e2d-c9ad1b951c4c)


2. **Zugabfrage (Zeile und Spalte separat)**
    - Der aktuelle Spieler wird aufgefordert, **zuerst die Zeile (1-3)** einzugeben.
    - Danach wird er aufgefordert, **die Spalte (1-3)** einzugeben.
    - Das Zeichen (`X` oder `O`) wird an der entsprechenden Position platziert.
    - Danach ist der nächste Spieler an der Reihe.
  
![Bildschirmfoto vom 2025-03-20 08-58-57](https://github.com/user-attachments/assets/ef6667b5-967d-4efe-93f7-1cd1edbeaa46)


3. **Gewinnbedingungen:**
    - Ein Spieler gewinnt, wenn er **drei Zeichen in einer Reihe, Spalte oder Diagonale** hat.
    - Falls das Spielfeld voll ist und niemand gewonnen hat, endet das Spiel **unentschieden**.
  
![Bildschirmfoto vom 2025-03-20 09-00-25](https://github.com/user-attachments/assets/f609a33f-9653-4400-85c0-bf11c1481955)


## Steuerung

| Abfrage | Eingabe | Bedeutung |
|---------|--------|----------|
| **Zeilenabfrage** | `1` | Erste Zeile |
| **Spaltenabfrage** | `2` | Zweite Spalte |
| **Ergebnis** | `X` oder `O` wird in **Zeile 1, Spalte 2** gesetzt |

⚠ **Nur gültige Züge werden akzeptiert.** Falls ein Feld bereits belegt ist, muss ein anderer Platz gewählt werden.
