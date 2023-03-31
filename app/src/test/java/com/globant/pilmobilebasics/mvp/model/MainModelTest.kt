package com.globant.pilmobilebasics.mvp.model

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class MainModelTest {

    private lateinit var model: MainModel

    @Before
    fun setup() {
        model = MainModel()
    }

    @Test
    fun testGetCount() {
        assertEquals("0", model.getCount())
    }

    @Test
    fun testReset() {
        model.increment("1")
        model.reset()
        assertEquals("0", model.getCount())
    }

    @Test
    fun testIncrement() {
        model.increment("1")
        assertEquals("1", model.getCount())
    }

    @Test
    fun testDecrement() {
        model.increment("1")
        model.decrement("1")
        assertEquals("0", model.getCount())
    }
}
