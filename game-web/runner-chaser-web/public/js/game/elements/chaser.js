class Chaser extends BoardElement {
    constructor(x, y) {
        super(x, y);
        this.type = 'Chaser';
        this.life = 3; // Example life value
    }

    setTarget(gameElements) {
        // Logic to set the target for the chaser
    }

    move() {
        // Logic for chaser movement
    }

    update() {
        // Logic to update chaser state
    }
}