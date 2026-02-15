class Role {
    constructor(name, life) {
        this.name = name;
        this.life = life;
    }

    getLife() {
        return this.life;
    }

    setLife(life) {
        this.life = life;
    }

    takeDamage(amount) {
        this.life -= amount;
        if (this.life < 0) {
            this.life = 0;
        }
    }

    isAlive() {
        return this.life > 0;
    }
}