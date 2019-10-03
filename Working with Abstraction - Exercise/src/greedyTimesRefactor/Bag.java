package greedyTimesRefactor;

import greedyTimesRefactor.Items.Cash;
import greedyTimesRefactor.Items.Gem;
import greedyTimesRefactor.Items.Gold;

public class Bag {

    private long size;
    private long capacity;

    private Gold gold;
    private Gem gem;
    private Cash cash;

    public Bag(long size) {

        this.size = size;

        this.gold = new Gold();
        this.gem = new Gem();
        this.cash = new Cash();

    }

    public long getSize() {
        return size;
    }


    public long getCapacity() {
        return capacity;
    }

    public void addGold(long gold) {

        this.capacity += gold;
        this.gold.addGold(gold);
    }

    public void addGem(String name, long gem) {
        if (this.gold.getQuantity() >= this.gem.getQuantity() + gem) {
            this.gem.addGem(name, gem);
        }
    }

    public void addCash(String name, long cash) {
        if (this.gem.getQuantity() >= this.cash.getQuantity() + cash) {
            this.cash.addMoney(name, cash);
        }
    }

    @Override
    public String toString() {

        return this.gold.toString() +
                this.gem.toString() +
                this.cash.toString().trim();
    }
}
