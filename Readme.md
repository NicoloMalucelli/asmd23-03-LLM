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