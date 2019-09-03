 _____                        ___                 
/  ___|                      |_  |                
\ `--. _ __   __ _  ___ ___    | | __ _ _ __ ___  
 `--. \ '_ \ / _` |/ __/ _ \   | |/ _` | '_ ` _ \ 
/\__/ / |_) | (_| | (_|  __/\__/ / (_| | | | | | |
\____/| .__/ \__,_|\___\___\____/ \__,_|_| |_| |_|
      | |                                         
      |_|           

Space Jam is developed by Euan Widjaja and Timothy O'Neill with Java's Swing using the Eclipse IDE.

1) Getting Started:
    - Prerequisites: Game uses the fonts Futura and Phosphate, both which are unavailable in Linux and Windows. However, they have been imported within  the game and they should show properly without any errors.

2) Running the Game from Eclipse:
    - Open the Eclipse IDE from a Java compatible computer
    - Import your files by clicking File > Open Projects From File System
    - On import source, click directory and find the game folder (SpaceJam-master)
    - Click finish and your files should have been imported
    - Then choose the src folder inside the SpaceJam-master folder
    - Open the main package
    - Open the GameEnvironment class
    - Run the class and play the game
    
3) Running the Game Through the Terminal:
    - Extract the game folder, which will contain a runnable jar
    - Open the terminal inside the game folder
    - Type the following command java -jar ewi45_teo31_SpaceJam.jar
    - Play the game

4) Basics of the Game:
    - The objective of the game is to get enough transporter pieces for your crew to head back to Earth.
    - The amount of transporter pieces you are to find is scaled by the number of days you are playing for (Number of days * (2/3)).
    - Throughout your journey, there will be several hindrances your crew will have to overcome to win the game.
    - These include the random occurrences of the Space Plague that infect your members, Alien Pirates thats steal your items, and Asteroids that damage your spaceship.
    - The Space Plague can be cured by healing a particular crew member with a 'cure'.
    - Alien Pirates can be prevented by choosing a member of type 'Terminator'.
    - Asteroids cannot be prevented, but a spaceship can be repaired by 5% by crew members:
        - Damage of spaceship is scaled by 4.2% when health level is over 50%.
        - Below 50%, it decreases by 19%.
        - Crew members of type 'Builder' have a repair rate of 15%.
    - You win the game by obtaining all the transporter pieces.
    - You lose the game when your spaceship explodes, malfunctions, your crew members are all dead, or when the number of days are maxed and transporter pieces are not all found.
 
5) Credits:
    - All images were free for use with modification from these websites
        https://imgur.com/r/retrofuturism/FVl4fDJ
        https://imgur.com/gallery/RbV0Q
        https://www.creativebloq.com/graphic-design/space-inspired-21514320/2
        https://static1.squarespace.com
        https://www.artstation.com/
        https://www.istockphoto.com/nz/photos/astronaut-animated?assettype=image&mediatype=photography&phrase=astronaut%20animated&sort=best
    - Paintings:
        Construction of a Space Station - Klaus Burgle, 1950
        Saturn Devouring His Son - Francisco Goya, 1819-1823

