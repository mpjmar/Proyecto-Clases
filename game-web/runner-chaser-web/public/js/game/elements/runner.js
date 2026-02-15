class Runner extends BoardElement {
    constructor(x, y) {
        super(x, y);
        this.life = 3; // Initial life for the runner
        this.speed = 2; // Speed of the runner
    }

    setTarget(gameElements) {
        // Logic to set the target for the runner
    }

    move() {
        // Logic for the runner's movement
    }

    takeDamage() {
        this.life--;
        if (this.life <= 0) {
            this.die();
        }
    }

    die() {
        // Logic for when the runner dies
    }
}