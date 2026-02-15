// This file manages user input, capturing keyboard events and translating them into game actions.

class InputHandler {
    constructor() {
        this.keys = {};
        this.bindEvents();
    }

    bindEvents() {
        window.addEventListener('keydown', (event) => {
            this.keys[event.key] = true;
        });

        window.addEventListener('keyup', (event) => {
            this.keys[event.key] = false;
        });
    }

    isKeyPressed(key) {
        return this.keys[key] === true;
    }

    resetKeys() {
        this.keys = {};
    }
}

const inputHandler = new InputHandler();
export default inputHandler;