package com.company;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LinkedListTest {
    @Test
    public void newListIsEmpty() {
        assertThat(new LinkedList().size(), equalTo(0));
    }

    @Test
    public void getItemAtIndexZero() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Eric");
        assertEquals("Eric", list.get(0));
    }

    @Test
    public void toStringIsPretty() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        assertEquals("[a, b]", list.toString());
    }

    @Test
    public void afterAddingOneItem_sizeMatches() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Dimitris");
        assertThat(list.size(), equalTo(1));
        list.add("Jack");
        assertThat(list.size(), equalTo(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void gettingIndexZeroFromEmptyListThrowsException() {
        new LinkedList().get(0);
    }

    @Test
    public void testRemoveFirstItem() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.remove("a"));
        assertFalse(list.remove("x"));
        assertThat(list.size(), equalTo(2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromNegativeIndexThrowsException() {
        new LinkedList().remove(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyListAtPositionZeroThrowsException() {
        new LinkedList().remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromBeyondEndOfListThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.remove(3);
    }

    @Test
    public void removeFirstElementByIndex() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        assertThat(list.remove(0), equalTo("a"));
        assertThat("size", list.size(), equalTo(2));
        assertThat(list.toString(), equalTo("[b, c]"));
    }


    @Test
    public void removeFromEmptyListReturnsFalse() {
        assertFalse(new LinkedList<String>().remove("xyz"));
    }

    @Test
    public void removeFromListContainingOneItem() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");

        assertFalse(list.remove("xyz"));
        assertTrue(list.remove("a"));
    }

    @Test
    public void doesListContainElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.contains("b"));
        assertFalse(list.contains("xxx"));
    }

    @Test
    public void removeElementFromList() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.contains("b"));
        assertTrue(list.remove("b"));
        assertFalse(list.remove("z"));
        assertFalse(list.contains("b"));
        assertThat(list.size(), equalTo(2));
        assertThat(list.toString(), equalTo("[a, c]"));
    }

    @Test
    public void clearAllElementsFromList() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.clear();
        assertThat(list.size(), equalTo(0));
    }

    @Test
    public void removeLastElementFromList() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.remove("c"));
        assertThat(list.size(), equalTo(2));

    }}
