# My Personal Project: 
## Windows Fighter x64 

***What will it do?***

My project will be a boss fight and "bullet-hell" type game, where the player
controls a character that attacks automatically, on a vertically scrolling screen. 
The player must:
- Avoid enemy projectiles, hence the name "bullet hell"
- Deal as much damage to the boss enemy as they can in the time provided
- Collect different drops from the boss as it takes damage for a boost in score
  or combat ability

There will be a single boss enemy to fight, with a time limit of 3 minutes to battle it.
As the name is a pun on the Windows x64 system and the Windows Defender antivirus, 
the game will be computer themed. The player will control an antivirus icon, 
and the boss will be a graphical depiction of a virus.

***Who will use it?***

I intend for this game to be played by everyone who finds it. However, the target 
demographic will be people with backgrounds in computers, as the name of the game 
as well as its content frequently references things to do with computers.

***Why is this project of interest to you?***

When I was young, I enjoyed and was skilled at bullet hell games such as Strikers 1945. 
However, my favorite games, the *"iFighter"* series on mobile devices, were discontinued 
without warning. No other game I played could take iFighter's place, so I eventually 
became distant from the bullet hell genre as a whole. I want to make a game that will 
bring others similar amounts of enjoyment that iFighter brought me. 
I also want to incorporate my Computer Science background into this game, 
to combine two of my favorite things.

## User Stories

- As a user, I want to be able to view the controls from the main menu.
- As a user, I want to be able to start a game, although it will be
wholly text based for now.
- As a user, I want to be able to simulate the enemy firing bullets, adding the
  bullet to a "hazards" field in the game class.
- As a user, I want to be able to collect upgrades up to a maximum limit of 8.
- As a user, I want to be able to change my weapon type from 2 choices.
- As a user, I want to be able to collect and use bombs (the firewall), which
  will clear all hazards from the game.
- As a user, I want the current state of the game (upgrade level, weapon type,
  firewall amount, amount of hazards) to save after returning to the main menu.
- As a user, on the main menu, I want the option to either load the previous 
  saved game or start a new game.

NOTE: In the final game, hazards will not be saved. Instead, the game will save
at the last HP threshold the player reduced the boss to, and starting a game there 
will give a brief grace period where neither you nor the boss can attack.