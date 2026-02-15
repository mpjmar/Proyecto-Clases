# runner-chaser-web/runner-chaser-web/README.md

# Runner Chaser Game

## Overview
The Runner Chaser Game is a web-based game where players control runners trying to evade chasers on a grid-based board. The objective is for the runners to survive while the chasers attempt to catch them.

## Project Structure
```
runner-chaser-web
├── public
│   ├── index.html          # Main HTML document
│   ├── css
│   │   └── styles.css      # Styles for the web application
│   └── js
│       ├── main.js         # Main JavaScript file
│       ├── game
│       │   ├── board.js    # Board class for managing the game board
│       │   ├── elements
│       │   │   ├── boardElement.js  # Base class for game elements
│       │   │   ├── chaser.js         # Chaser class
│       │   │   ├── runner.js         # Runner class
│       │   │   └── role.js           # Role class for common properties
│       │   ├── engine
│       │   │   ├── gameLoop.js       # Game loop logic
│       │   │   └── collision.js      # Collision detection
│       │   ├── generator
│       │   │   └── elementsGenerator.js # Functions to generate game elements
│       │   ├── input
│       │   │   └── inputHandler.js   # User input management
│       │   └── utils
│       │       ├── listUtils.js      # Utility functions for lists
│       │       └── domUtils.js       # Utility functions for DOM manipulation
│       └── config
│           └── settings.js           # Configuration settings
├── assets
│   └── fonts                      # Font files used in the application
└── README.md                      # Project documentation
```

## Setup Instructions
1. Clone the repository to your local machine.
2. Open the `public/index.html` file in a web browser to start the game.
3. Ensure that all assets and dependencies are correctly linked.

## Game Rules
- Players control runners that must avoid being caught by chasers.
- The game ends when all runners are caught or when a set number of moves is reached.
- Players can use keyboard inputs to control the runners' movements.

## Technologies Used
- HTML
- CSS
- JavaScript

## Contributing
Feel free to submit issues or pull requests to improve the game or add new features.