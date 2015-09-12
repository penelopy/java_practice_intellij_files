package com.company;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class IntListTest {

    @Test
    public void newListIsEmpty() {
        assertThat(new IntList().size(), equalTo(0));
    }

    @Test
    public void addElementThenTestSize() {
        IntList list = new IntList();

        list.add(5);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(9);

        assertThat(list.size(), equalTo(5));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void searchForIndexOutOfRange_throwsIndexOutOfBoundsError() {
        IntList list = new IntList();

        list.add(5);
        list.add(4);
        list.add(7);
        list.add(9);

        list.get(6);

    }

    @Test
    public void listExpandsWhenAddingBeyondInitialCapacity() {
        IntList list = new IntList();
        for (int i=0; i<100; i++) {
            list.add(i);
        }
        assertThat(list.size(), equalTo(100));
        assertThat(list.get(88), equalTo(88));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemovingFromEmptyListBlowsUp() {
        new IntList().remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemovingFromNegativeIndexBlowsUp() {
        new IntList().remove(-1);
    }

    @Test
    public void testRemovingFromLastIndex() {
        IntList list = new IntList();
        list.add(5);
        list.add(10);
        list.add(20);

        assertThat(list.remove(2), equalTo(20));
        assertThat(list.size(), equalTo(2));
        assertThat(list.toString(), equalTo("[5, 10]"));
    }

    @Test
    public void testRemovingFromMiddleOfList() {
        IntList list = new IntList();
        list.add(5);
        list.add(10);
        list.add(20);
        assertThat(list.remove(1), equalTo(10));
        assertThat(list.size(), equalTo(2));
        assertThat(list.toString(), equalTo("[5, 20]"));
    }

    @Test
    public void getMethodReturnsCorrectValue() {
        IntList list = new IntList();
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(9);

        IntList list2 = new IntList();
        list2.add(44);

        assertThat(list.get(2), equalTo(7));
        assertThat(list.get(3), equalTo(9));
        assertThat(list2.get(0), equalTo(44));
    }

    @Test
    public void toStringEmptyList() {
        assertThat(new IntList().toString(), equalTo("[]"));
    }

    @Test
    public void toStringSingleItemList() {
        IntList list = new IntList();
        list.add(10);

        assertThat(list.toString(), equalTo("[10]"));

    }
}
