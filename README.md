# Hangman With Gallows

# Gallows
The user can choose if gallows will be used. 
If the gallows is used, a body part will be added each time the user guesses incorrectly.
If the full person (named Bowly because I looked at the bowling pin sitting in my room and was inspired) is formed before the word is guessed, the user will lose that round.
If the gallows are not used then the user will be able to guess until the word is guessed correctly.

# User Error
The user cannot guess the same letter twice, however this will not count as a guess.
The user also cannot input more than one letter at a time, this will also not count as a guess.
When asked to continue or whether to use the gallows, the user may enter y or n. 
If something other than these two options is entered when asked to continue the game will get very angry and not allow you to play any more because you can't follow instructions.
If something other than these two options is entered when asked to use the gallows the game will make the choice for you and you will use the gallows. Choose wisely!
  
# Classes
The Words class contains the list of words and selects a random one. It does not allow repeat words to be used.
The Display class deals with everything printed to the terminal.
The GameController class is where the actual game play happens.

# Time Used
3 Hours 27 Minutes 22 Seconds
