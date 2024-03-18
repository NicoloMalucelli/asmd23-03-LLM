# Application of LLM in Software Engineering

## Task 1: CODE GENERATION

### Attempt (a): ChatGPT 3.5 zero-shot 

Given prompt:
```
 Scopo di questo esercizio è realizzare una GUI che realizza la possibilità di selezionare via via aree rettangolari, 
 come segue:
- l'utente clicka una cella, e lì ci compare un '1'
- l'utente clicka un'altra cella, e a questo punto tutte le celle che stanno nel rettangolo che ha come estremi le due 
celle clickate assumono un '*'
- si ricomincia col punto 1, finché non succede che tutte le celle hanno un '*', a quel punto le si disabilitano tutte

    requisiti non funzionali:
     - scorporamento via delegazione di tutti gli aspetti che non sono di view in una interfaccia (Logic) +classe
      esterna (LogicImpl)     
```

The obtained solution is not working and moreover it doesn't separate the View aspect from the Logic.

- The GUI class contains methods that should normally belong to the Logic (e.g., <tt>allCellsSelected</tt>,
<tt>updateRectangle</tt>, <tt>disableAllCells</tt>). LogicImpl contains instead just a method that call the public methods
of the GUI.
- The number of rows and cols are not given as parameters of the constructor but are defined inside the GUI class.
- The logic of the application is wrong. At each click, all the cells between the clicked cell and the top-left corner are
marked with *. First click and second click are treated in the same way.
- When all the cells are marked with * the game doesn't end until an additional click on any cell


### Attempt (b): ChatGPT 3.5 few-shot

Given prompt:

```
The obtained solution is not working and moreover it doesn't separate the View aspect from the Logic.

    - The GUI class contains methods that should normally belong to the Logic (e.g., allCellsSelected, updateRectangle, disableAllCells). LogicImpl contains instead just a method that call the public methods of the GUI.
    - The number of rows and cols are not given as parameters of the constructor but are defined inside the GUI class.
    - The logic of the application is wrong. At each click, all the cells between the clicked cell and the top-left corner are marked with *. First click and second click are treated in the same way.
    - When all the cells are marked with * the game doesn't end until an additional click on any cell
```

As second attempt, I tried to tell ChatGPT what was wrong in the previous implementation. 

The new implementation correct only the last problem (the game not ending in the right moment), but all the other 
problems are still present.

Therefore, describe all the problem of the first solution in one shot seems to be the wrong strategy

### Attempt (c): ChatGPT 3.5 few-shot

Given prompt:
```
the first click should not already mark the cells with *, but put a 1 instead.
Moreover, when the second click occures, only the cells between the first and the second click should be marked, not all the cell between (0,0) and the clicked one
```

This solution is almost working, but it introduced again the error that the solution (b) initially solved.

Given prompt:
```
refactor gui and logic so that ALL the public methods are in the logic and the GUI simply call them 
```

The solution obtained with this last prompt is the one organized in the better way, anyway is still not good enough.

- The Logic contains Swing dependencies
- The game doesn't end in the right moment but one click later