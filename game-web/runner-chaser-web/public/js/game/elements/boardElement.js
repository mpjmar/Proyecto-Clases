class BoardElement {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.alive = true;
    }

    move(newX, newY) {
        this.x = newX;
        this.y = newY;
    }

    isAlive() {
        return this.alive;
    }

    setAlive(status) {
        this.alive = status;
    }
}