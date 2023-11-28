package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void nameAndValues() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].getName());
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());
    }

    //TODO add a lot of tests (see TexttestFixture) - but I am not in the mood for it now...and I have a fulltime life next to the job
    //TODO as a consultant on the beach it could maybe trigger me more ;-)
    //As a senior I am in no mood today, headache and kids are my prio today...

}
