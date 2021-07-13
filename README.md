# Phoenix-Language (Simple Imperative Language Grammar)

![Phoenix-Language](img.jpg)

## The grammar of the language using a tool named JavaCC

### The language supports evaluating the grammar expressions

* Digit   → 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
* Letter → a | b | c | d | e | f
* Num   → Digit Num  |  ε
* Var     →  Letter Var  |  ε
* AExp  →  Num | Var | (AExp + AExp) | (AExp −AExp)
* BExp  →  tt | ff | (AExp == AExp) | ! BExp | (BExp ^ BExp)
* Com   →  skip | Var := AExp | Com; Com | if BExp then Com else Com | while BExp do Com

