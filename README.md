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

# Errors found after time expired
Later in the day, after I had finished my coding challenge, I let someone play the hangman game and I discovered that if they wanted to continue playing they could not
guess letters that they had previously guessed in the previous round and the gallows did not reset when a new round was started. To fix this I added lines 26-27 in the
Display.java file. Line 26 clears the list of letters that had been incorrectly guessed when the user decides to play again. Line 27 resets the numBodyParts variable
which is used to decide how many body parts to print in the gallows. I also added a space on line 224 in the Display.java file. This has nothing to do with the
functionality of the game, I just added the space to make it look nicer.
