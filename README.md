# My Personal Project: 
## Bullet Hell Simulator
***What will it do?***

My project will be a sandbox/simulator, where the player can simulate scenarios common
in most bullet hell games. These scenarios include:
- Enemies firing bullets from the top of the screen
- Changing weapon type
- Collecting upgrades
- Collecting "firewalls" functioning as bombs
- Using firewalls to clear bullets from the screen

***Who will use it?***

I intend for this game to be played by everyone who finds it. However, the target 
demographic will be fans of bullet hell games such as Touhou or Strikers 1945.

***Why is this project of interest to you?***

When I was young, I enjoyed and was skilled at bullet hell games. However, my favorite games 
of this type, the *"iFighter"* series on mobile devices, were discontinued without warning. 
No other game I played could take iFighter's place, so I eventually became distant from the bullet hell 
genre as a whole. No other bullet hell game I've played since was quite like how iFighter was, so I want
to create a simulation that captures the essence of the mechanics of the game, so people like me can easily
relive memories of a discontinued game.

## User Stories

- As a user, I want to be able to view the controls from the main menu and the game screen.
- As a user, I want to be able to start a game.
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

## Phase 4: Task 2
Event Log:
Thu Mar 31 16:55:46 PDT 2022
Enemy has fired bullet.
Thu Mar 31 16:55:46 PDT 2022
Enemy has fired bullet.
Thu Mar 31 16:55:46 PDT 2022
Enemy has fired bullet.
Thu Mar 31 16:55:49 PDT 2022
Enemy has fired bullet.
Thu Mar 31 16:55:50 PDT 2022
Enemy has fired bullet.
Thu Mar 31 16:55:54 PDT 2022
Firewall used, all enemy bullets cleared.

Note that I manually add "Event Log:" in the part where I print out the events when the game closes.
The game adds an event every time a bullet is added to the game, and also when a firewall is used to
clear the added bullets.

## Phase 4: Task 3
In terms of design, my project mainly revolves around the classes Game and GameFrame. The Bullet class serves
as the X that can be added to a Y, the Game class. Game is where all the program's inner workings lie, so 
it calls methods from EventLog to log the events of adding and removing bullets, and implements Writable to
be able to convert game data to JSON for reading and writing. 
JSONWriter and JSONReader also implement Writable to facilitate saving and loading behaviour, and are present in
GameFrame where saving and loading are connected to buttons. As GameFrame is where the game's graphical portion 
lies, it will have a field of type Game. It's also behind the functionality of printing the EventLog when the
window closes and the program is exited. ControlsFrame and BackgroundPanel are separate classes whose constructors
are called in GameFrame to reduce some repetition.

Overall, I think my project design is pretty solid, since there isn't any obvious coupling, so changes can
safely be made to one class without breaking other classes. However, if I had more time, I would have:
- Either made statsBar into its own class, or made some kind of helper to reduce the method length of creating 
the stats bar
- Created a separate GamePanel class also to reduce method length as well as the size of the GameFrame class,
I currently have most of the UI stuff in my GameFrame class because I was unable to get the passing of values
for multiple JPanels with functionality like buttons to work properly