// This file handles collision detection between game elements, determining interactions between chasers and runners.

class Collision {
    static checkCollision(elementA, elementB) {
        return (
            elementA.x < elementB.x + elementB.width &&
            elementA.x + elementA.width > elementB.x &&
            elementA.y < elementB.y + elementB.height &&
            elementA.y + elementA.height > elementB.y
        );
    }

    static handleCollision(chaser, runner) {
        if (this.checkCollision(chaser, runner)) {
            runner.takeDamage(chaser.attackPower);
            if (runner.getLife() <= 0) {
                // Handle runner elimination
                console.log("Runner eliminated!");
            }
        }
    }
}

export default Collision;